package com.accounting.booknote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to express that a request doesn't conform to the expected format
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidFormatException extends RuntimeException {

    public InvalidFormatException(String message) {
        super(message);
    }
}
