package com.cgz.assignment.domain.exception;

/**
 * Created by czarek on 10.08.16.
 */
public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
}
