package com.home.accountsservice.exception;

import java.time.LocalDateTime;

public class GAException extends Throwable{

    private LocalDateTime timestamp;
    private String message;
    private int status;

    public LocalDateTime getTimestamp ( ) {
        return timestamp;
    }

    public void setTimestamp (LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage ( ) {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public int getStatus ( ) {
        return status;
    }

    public void setStatus (int status) {
        this.status = status;
    }
}
