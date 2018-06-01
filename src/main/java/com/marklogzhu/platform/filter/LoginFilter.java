package com.marklogzhu.platform.filter;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import com.marklogzhu.platform.common.Const;
import com.marklogzhu.platform.common.RequestHolder;
import com.marklogzhu.platform.pojo.User;
import com.marklogzhu.platform.util.CookieUtil;
import com.marklogzhu.platform.util.JsonUtils;
import com.marklogzhu.platform.util.redis.RedisShardedPoolUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * 登录拦截器
 */
public class LoginFilter implements Filter {

    private static Set<String> exclusionUrlSet = Sets.newConcurrentHashSet();

    /**
     * 登录 URL
     */
    private static final String LOGIN_URL = "/user/login.page";

    @Override
    public void init(FilterConfig filterConfig) {
        String exclusionUrls = filterConfig.getInitParameter("excludedPages");
        if (StringUtils.isNotEmpty(exclusionUrls)) {
            List<String> exclusionUrlList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(exclusionUrls);
            exclusionUrlSet = Sets.newConcurrentHashSet(exclusionUrlList);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        // 判断是否是不需要拦截的 URL
        if (exclusionUrlSet.contains(servletPath)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 获取登录 token
        String loginToken = CookieUtil.readLoginToken(request);
        if (StringUtils.isEmpty(loginToken)) {
            jumpToLogin(response);
            return;
        }
        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
        User user = JsonUtils.string2Obj(userJsonStr, User.class);
        if (user == null) {
            jumpToLogin(response);
            return;
        }
        RequestHolder.add(user);
        RequestHolder.add(request);
        refreshSessionTime(loginToken);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }



    /**
     * 刷新 Session 过期时间
     * @param loginToken   登录 token
     */
    private void refreshSessionTime(String loginToken){
        RedisShardedPoolUtil.expire(loginToken, Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
    }
    /**
     * 跳转至登录页面
     *
     * @param  response response 对 象
     * @throws IOException 异常对象
     */
    private void jumpToLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect(LOGIN_URL);
    }
}
