package com.chenbing.utils;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 统一的返回结果
 * Created by zhaoqixiang on 2017/8/5.
 */
public class Result<T> implements Serializable{

    public Result(){

    }

    public Result(T data){
        this.data = data;
    }

    private int statusCode = HttpStatus.OK.value();
    private int status = HttpStatus.OK.value();
    private Integer code = 0;
    private String msg = "";
    private String callback = "";
    private T data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
