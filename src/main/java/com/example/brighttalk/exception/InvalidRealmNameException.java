package com.example.brighttalk.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by m.karandish on 6/13/2019.
 */
public class InvalidRealmNameException extends RealmException{

    @Override
    public String getErrorDesc() {
        return "Invalid Realm Name";
    }

    @Override
    public HttpStatus getHttpStatuse() {
        return HttpStatus.BAD_REQUEST;
    }
}
