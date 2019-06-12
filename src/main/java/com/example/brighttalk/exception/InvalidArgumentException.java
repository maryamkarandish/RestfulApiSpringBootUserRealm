package com.example.brighttalk.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by m.karandish on 6/12/2019.
 */
public class InvalidArgumentException extends RealmException{
    @Override
    public String getErrorDesc() {
        return "Invalid Argument";
    }

    @Override
    public HttpStatus getHttpStatuse() {
        return HttpStatus.BAD_REQUEST;
    }
}
