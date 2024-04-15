package com.kodilla.events.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DivisionException.class)
    public ResponseEntity<Object> handleDivisionException(DivisionException ex) {
        String message = ex.getMessage();
        log.error(message, ex);

        Map<String, Object> body = new HashMap<>();
        body.put("httpStatus", ex.getHttpStatus());
        body.put("message", message);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
