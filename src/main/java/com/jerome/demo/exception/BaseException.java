package com.jerome.demo.exception;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public abstract class BaseException extends RuntimeException {

    private final ErrorCode code;
    private final Map<String, Object> data;

    public BaseException(ErrorCode code, Map<String, Object> data) {
        super(code.getMessage());
        this.code = code;
        this.data = data;
    }

    public BaseException(ErrorCode code, Map<String, Object> data, Exception e) {
        super(code.getMessage(), e);
        this.code = code;
        this.data = data;
    }

}
