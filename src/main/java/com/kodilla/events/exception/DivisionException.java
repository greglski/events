package com.kodilla.events.exception;


import lombok.Getter;

@Getter
public class DivisionException extends ArithmeticException {

    private final String httpStatus;

    public DivisionException(String message, String httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
