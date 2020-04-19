package com.accounting.validation;

import com.accounting.booknote.validation.IDValidation;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for the transaction ID validation
 */
public class IDValidationTest {

    @Test
    public void shouldReturnEmptyWhenValidID() {
        IDValidation validation = new IDValidation();
        List<String> errors = validation.validate(UUID.randomUUID().toString());
        assertTrue(errors.isEmpty());
    }

    @Test
    public void shouldFailWhenInvalidID() {
        IDValidation validation = new IDValidation();
        List<String> errors = validation.validate("invalid id");
        assertTrue(errors.contains("Transaction id must be a valid UUID"));
    }
}
