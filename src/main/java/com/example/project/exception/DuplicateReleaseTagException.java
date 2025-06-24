package com.example.project.exception;

public class DuplicateReleaseTagException extends RuntimeException {
    public DuplicateReleaseTagException(String message) {
        super(message);
    }
}
