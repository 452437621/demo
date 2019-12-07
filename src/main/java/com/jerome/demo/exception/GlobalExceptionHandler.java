package com.jerome.demo.exception;

import com.jerome.demo.controller.test.ExceptionController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice(assignableTypes = ExceptionController.class)
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorResponse> handleAppException(BaseException e, HttpServletRequest request) {
        if (e == null) {
            return null;
        }
        log.info(String.format("捕获异常：%s Data:%s", e.getClass(), e.toString()));
        ErrorResponse response = new ErrorResponse(e, request.getRequestURI());
        return ResponseEntity.status(e.getCode().getStatus()).body(response);
    }

}
