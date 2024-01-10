package com.example.demo.Answer;

import com.example.demo.utils.JsonUtil;

import java.io.Serializable;

public class Result<T extends Serializable> implements Serializable {

    private int status;

    private String message;

    private final T data;

    public Result(ReturnCode rc, T data) {
        this.status = rc.getCode();
        this.message = rc.getMsg();
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
