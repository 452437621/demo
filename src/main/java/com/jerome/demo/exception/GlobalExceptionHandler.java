package com.jerome.demo.exception;

import com.jerome.demo.controller.test.ExceptionController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(assignableTypes = ExceptionController.class)
@ResponseBody
public class GlobalExceptionHandler {

    ErrorResponse illegalArgs = new ErrorResponse(new IllegalArgumentException("参数错误！"));
    ErrorResponse resourceNotFound = new ErrorResponse(new ResourceNotFoundException("资源不存在！"));

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandle(Exception e) {
        if (e == null) {
            return null;
        }
        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgs);
        } else if (e instanceof ResourceNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceNotFound);
        }
        return null;
    }

}
