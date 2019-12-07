package com.jerome.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private Integer code;
    private Integer status;
    private String message;
    private String path;
    private Instant instant;
    private Map<String, Object> data;

    public ErrorResponse(BaseException e, String path) {
        this(e.getCode().getCode(), e.getCode().getStatus().value(), e.getCode().getMessage(), path, Instant.now(), e.getData());
    }

}
