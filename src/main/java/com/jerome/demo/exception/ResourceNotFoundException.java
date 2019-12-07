package com.jerome.demo.exception;

import lombok.Data;

import java.util.Map;

/**
 * 资源未找到
 */
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(Map<String, Object> map) {
        super(ErrorCode.RESOURCE_NOT_FOUND, map);
    }
}
