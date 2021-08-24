package com.home.accountsservice.util;

import com.home.accountsservice.dto.ResponseBean;

public class ServiceUtil {

    public static ResponseBean prepareResponseBean(String message, int code) {
        ResponseBean bean = new ResponseBean ();
        bean.setData ( message );
        bean.setCode ( code );
        return  bean;
    }
}
