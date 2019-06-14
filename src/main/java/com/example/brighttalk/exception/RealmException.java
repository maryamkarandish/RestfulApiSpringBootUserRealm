package com.example.brighttalk.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by m.karandish on 6/13/2019.
 * This exception class has been implemented by other exception classes
 */
public abstract class RealmException extends RuntimeException {
    public abstract String getErrorDesc();
    public abstract HttpStatus getHttpStatuse();
}
