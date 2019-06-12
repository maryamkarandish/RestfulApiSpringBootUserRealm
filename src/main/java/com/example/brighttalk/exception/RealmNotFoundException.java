package com.example.brighttalk.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by m.karandish on 6/12/2019.
 */
public class RealmNotFoundException extends RealmException {

    @Override
    public String getErrorDesc() {
        return "Realm Not Found";
    }

    @Override
    public HttpStatus getHttpStatuse() {
        return HttpStatus.BAD_REQUEST;
    }
}
