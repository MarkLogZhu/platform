package com.marklogzhu.platform.common;

import com.marklogzhu.platform.pojo.User;

import javax.servlet.http.HttpServletRequest;

/**
 * request 持有对象
 */
public class RequestHolder {

    private static final ThreadLocal<User> userHolder = new ThreadLocal<>();

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void add(User user) {
        userHolder.set(user);
    }

    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static User getCurrentUser() {
        return userHolder.get();
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        userHolder.remove();
        requestHolder.remove();
    }
}
