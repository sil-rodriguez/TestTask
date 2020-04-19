package com.accounting.booknote.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class to validate transaction ID format
 */
public class IDValidation implements Validator<String> {

    @Override
    public List<String> validate(String id) {
        List<String> errors = new ArrayList<>();
        try {
            UUID.fromString(id);
        } catch (IllegalArgumentException exception) {
            errors.add("Transaction id must be a valid UUID");
        }
        return errors;
    }
}
