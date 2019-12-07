package com.jerome.demo.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@ToString
public enum ErrorCode {

    RESOURCE_NOT_FOUND(1001, HttpStatus.NOT_FOUND, ""),
    REQUEST_VALIDATION_FAIL(1002, HttpStatus.BAD_REQUEST, "");

    private final int code;
    private final HttpStatus status;
    private final String message;

}
