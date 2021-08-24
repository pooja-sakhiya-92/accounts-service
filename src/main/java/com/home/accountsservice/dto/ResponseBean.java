package com.home.accountsservice.dto;

public class ResponseBean {

    private Object data;
    private int code;

    public Object getData ( ) {
        return data;
    }

    public void setData (Object data) {
        this.data = data;
    }

    public int getCode ( ) {
        return code;
    }

    public void setCode (int code) {
        this.code = code;
    }
}
