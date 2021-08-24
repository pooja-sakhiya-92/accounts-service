package com.home.accountsservice.exception;

import java.time.LocalDateTime;

public class AccountException extends GAException {
    public AccountException (String message) {
        System.err.println ( message );
        super.setMessage ( message );
        super.setTimestamp ( LocalDateTime.now () );
    }
}
