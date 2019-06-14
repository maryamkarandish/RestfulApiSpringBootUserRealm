package com.example.brighttalk.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by m.karandish on 6/13/2019.
 * This class class has been thrown exception when user try to add not interger ID or invalid argument
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
