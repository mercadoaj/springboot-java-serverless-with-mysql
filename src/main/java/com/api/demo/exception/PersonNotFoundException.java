package com.api.demo.exception;


public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Long id) {
        super("Person not found. id is: " + id);
    }

}