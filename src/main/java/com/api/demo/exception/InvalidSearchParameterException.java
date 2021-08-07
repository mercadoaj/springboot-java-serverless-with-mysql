package com.api.demo.exception;

public class InvalidSearchParameterException extends RuntimeException {

    public InvalidSearchParameterException(String param) {
        super("Invalid Search Parameters. " + param);
    }

}