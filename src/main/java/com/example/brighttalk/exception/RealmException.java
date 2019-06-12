package com.example.brighttalk.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by m.karandish on 6/12/2019.
 */
public abstract class RealmException extends RuntimeException {
    public abstract String getErrorDesc();
    public abstract HttpStatus getHttpStatuse();
}
