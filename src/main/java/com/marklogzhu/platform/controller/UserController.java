package com.marklogzhu.platform.controller;

import com.marklogzhu.platform.common.CodeMsg;
import com.marklogzhu.platform.common.Const;
import com.marklogzhu.platform.common.JsonData;
import com.marklogzhu.platform.dto.UserDTO;
import com.marklogzhu.platform.service.UserService;
import com.marklogzhu.platform.util.CookieUtil;
import com.marklogzhu.platform.util.JsonUtils;
import com.marklogzhu.platform.util.redis.RedisShardedPoolUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
@Slf4j
@Api(tags = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "获取登陆页面")
    @RequestMapping( value = "/login.page" ,method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @ApiOperation(value = "登录操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userName",value="用户名",required=true),
            @ApiImplicitParam(name="password",value="加盐后的密码",required=true)
    })
    @RequestMapping( value = "/login.json" ,method = RequestMethod.POST)
    @ResponseBody
    public JsonData login(UserDTO user, HttpServletResponse response, HttpSession session){
        JsonData jsonData = userService.login(user);
        if(jsonData.isSuccess()){
            // 客户端返回 cokkie
            CookieUtil.writeLoginToken(response,session.getId());
            // 服务端写入 redis
            RedisShardedPoolUtil.setEx(session.getId(), JsonUtils.obj2String(jsonData.getData()),Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
        }
        return jsonData;
    }

    @ApiOperation(value = "登出操作")
    @RequestMapping( value = "/logout.json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public JsonData logout(HttpServletRequest request,HttpServletResponse response){
        // 获取登录 token
        String loginToken = CookieUtil.readLoginToken(request);
        // 删除客户端 cokkie
        CookieUtil.delLoginToken(request,response);
        // redis 删除信息
        RedisShardedPoolUtil.del(loginToken);
        return JsonData.createBySuccessMessage(CodeMsg.SUCCESS_LOGOUT);
    }

}
