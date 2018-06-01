package com.marklogzhu.platform.service.impl;

import com.marklogzhu.platform.common.CodeMsg;
import com.marklogzhu.platform.common.Const;
import com.marklogzhu.platform.common.JsonData;
import com.marklogzhu.platform.dao.UserMapper;
import com.marklogzhu.platform.dto.UserDTO;
import com.marklogzhu.platform.pojo.User;
import com.marklogzhu.platform.pojo.UserExample;
import com.marklogzhu.platform.service.UserService;
import com.marklogzhu.platform.util.BeanValidator;
import com.marklogzhu.platform.util.MD5Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonData<UserDTO> login(UserDTO userParam) {
        BeanValidator.check(userParam);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userParam.getUserName());
        criteria.andStatusNotEqualTo(Const.UserStatus.DELETE);
        List<User> userList = userMapper.selectByExample(example);
        // 账号验证
        if(userList.size() <=0 ){
            return JsonData.createByErrorMessage(CodeMsg.USER_NOT_EXIST);
        }
        User user = userList.get(0);
        String encryptedPassword = MD5Utils.encryptPassword(userParam.getPassword(),user.getSalt());
        // 密码验证
        if(!user.getPassword().equals(encryptedPassword)){
            return JsonData.createByErrorMessage(CodeMsg.PASSWORD_ERROR);
        }
        // 判断账号是否处于冻结状态
        if(user.getStatus()==Const.UserStatus.FREEZE){
            return JsonData.createByErrorMessage(CodeMsg.USER_FREEZE);
        }
        // 密码验证完后应该销毁掉，防止泄露
        user.setPassword("");
        return JsonData.createBySuccess(CodeMsg.SUCCESS_LOGIN,assemblyUserDTO(user));
    }

    /**
     * 构造 UserDTO 对象
     * @param user  用户对象
     * @return
     */
    private UserDTO assemblyUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

}
