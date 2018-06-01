package com.marklogzhu.platform.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用 JSON 格式返回结果
 *
 * @param <T>
 */
public class JsonData<T> implements Serializable {

    private int status;

    private String msg;

    private T data;


    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return status == CodeMsg.SUCCESS.getCode();
    }


    public static JsonData createBySuccess() {
        return new JsonData(CodeMsg.SUCCESS.getCode());
    }

    public static <T> JsonData<T> createBySuccessMessage(CodeMsg msg) {
        return new JsonData<T>(msg.getCode(), msg.getMsg());
    }

    public static <T> JsonData createBySuccess(T data) {
        return new JsonData(CodeMsg.SUCCESS.getCode(), data);
    }

    public static <T> JsonData<T> createBySuccess(CodeMsg msg, T data) {
        return new JsonData<T>(msg.getCode(), msg.getMsg(), data);
    }

    public static JsonData createByError() {
        return new JsonData(CodeMsg.SERVER_ERROR.getCode(), CodeMsg.SERVER_ERROR.getMsg());
    }


    public static <T> JsonData<T> createByErrorMessage(CodeMsg msg) {
        return new JsonData<T>(msg.getCode(), msg.getMsg());
    }

    private JsonData(int status) {
        this.status = status;
    }

    private JsonData(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private JsonData(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private JsonData(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("status",status);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}