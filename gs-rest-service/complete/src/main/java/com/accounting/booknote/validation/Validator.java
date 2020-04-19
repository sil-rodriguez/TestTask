package com.accounting.booknote.validation;

import java.util.List;

/**
 * Interface to validate request format
 */
public interface Validator<T> {

    List<String> validate(T request);
}
