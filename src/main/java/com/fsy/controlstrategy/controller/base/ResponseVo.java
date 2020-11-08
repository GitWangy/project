package com.fsy.controlstrategy.controller.base;

import java.io.Serializable;

public class ResponseVo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private T data;

    public ResponseVo(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseVo() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}