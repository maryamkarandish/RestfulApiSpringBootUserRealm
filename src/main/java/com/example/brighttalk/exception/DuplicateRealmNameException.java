package com.example.brighttalk.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by m.karandish on 6/13/2019.
 */
public class DuplicateRealmNameException extends RealmException {
    @Override
    public String getErrorDesc() {
        return "Name is Duplicate in DataBase";
    }

    @Override
    public HttpStatus getHttpStatuse() {
        return HttpStatus.BAD_REQUEST;
    }
}
