package com.example.brighttalk.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by m.karandish on 6/13/2019.
 * This class class has been thrown exception when user try to add empty or null name
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
