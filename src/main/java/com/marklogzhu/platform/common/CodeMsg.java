package com.marklogzhu.platform.common;

public class CodeMsg {
    private int code;
    private String msg;

    // 通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg PAGE_ERROR = new CodeMsg(500001,"页面请求异常，异常原因：%s");
    public static CodeMsg UNKNOWN_JSON_ERROR = new CodeMsg(500002,"未定义JSON数据请求异常，异常原因：%s");
    public static CodeMsg UNKNOWN_ERROR = new CodeMsg(500003,"未定义请求异常，异常原因：%s");
    public static CodeMsg PARAM_CHECK_ERROR = new CodeMsg(500004,"参数检验错误，错误提示：%s");
    public static CodeMsg TIME_NOT_MATCH_ERROR = new CodeMsg(500005,"%s");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "请求非法");
    public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "访问太频繁！");
    //登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg USER_NOT_EXIST = new CodeMsg(500214, "用户不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "用户名或密码错误");
    public static CodeMsg USER_FREEZE = new CodeMsg(500215, "账号处于冻结状态");
    public static CodeMsg SUCCESS_LOGIN = new CodeMsg(0,"登录成功");
    public static CodeMsg SUCCESS_LOGOUT = new CodeMsg(0,"登出成功");
    public static CodeMsg ERROR_LOGIN = new CodeMsg(500216,"登录失败，错误原因：%s");
    // 其他模板自定义
    private CodeMsg( int code,String msg ) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }
}
