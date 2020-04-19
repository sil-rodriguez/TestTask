package com.accounting.booknote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to express that an account doesn't have enough balance to perform the required operation
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
