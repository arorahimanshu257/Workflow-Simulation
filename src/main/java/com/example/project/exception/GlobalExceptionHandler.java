package com.example.project.exception;

import com.example.project.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private String generateTraceId() {
        return UUID.randomUUID().toString();
    }

    @ExceptionHandler(MilestoneNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMilestoneNotFound(MilestoneNotFoundException ex) {
        return buildErrorResponse("MILESTONE_NOT_FOUND", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReleaseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleReleaseNotFound(ReleaseNotFoundException ex) {
        return buildErrorResponse("RELEASE_NOT_FOUND", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateMilestoneTitleException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateMilestoneTitle(DuplicateMilestoneTitleException ex) {
        return buildErrorResponse("DUPLICATE_MILESTONE_TITLE", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidMilestoneDateRangeException.class)
    public ResponseEntity<ErrorResponse> handleInvalidMilestoneDateRange(InvalidMilestoneDateRangeException ex) {
        return buildErrorResponse("INVALID_DATE_RANGE", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateReleaseTagException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateReleaseTag(DuplicateReleaseTagException ex) {
        return buildErrorResponse("DUPLICATE_RELEASE_TAG", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReleaseAlreadyAssociatedException.class)
    public ResponseEntity<ErrorResponse> handleReleaseAlreadyAssociated(ReleaseAlreadyAssociatedException ex) {
        return buildErrorResponse("RELEASE_ALREADY_ASSOCIATED", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .reduce((m1, m2) -> m1 + "; " + m2)
                .orElse("Validation error");
        return buildErrorResponse("VALIDATION_ERROR", msg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        return buildErrorResponse("INTERNAL_ERROR", "An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(String code, String message, HttpStatus status) {
        ErrorResponse error = new ErrorResponse(code, message, generateTraceId());
        return new ResponseEntity<>(error, status);
    }
}
