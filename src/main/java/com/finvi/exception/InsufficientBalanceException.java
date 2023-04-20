package com.finvi.exception;

public class InsufficientBalanceException extends  RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
