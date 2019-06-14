package com.example.brighttalk.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by m.karandish on 6/13/2019.
 * This esception class has been thrown exception when
 * user try to fetch realm that is not exist in Database
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
