package com.doranco.exception;

public class NotFoundEntityException extends Exception {

    public NotFoundEntityException() {
        super();
    }

    public NotFoundEntityException(String message) {
        super(message);
    }
}