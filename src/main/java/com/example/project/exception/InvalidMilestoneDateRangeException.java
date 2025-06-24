package com.example.project.exception;

public class InvalidMilestoneDateRangeException extends RuntimeException {
    public InvalidMilestoneDateRangeException(String message) {
        super(message);
    }
}
