package com.cos.instagram.handler;

import com.cos.instagram.handler.ex.CustomValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController     // 모든 예외를 낚아챈 다음 응답을 하기 위한 컨트롤러라는 의미
@ControllerAdvice  // 모든 예외를 다 낚아챔
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)    // CustomValidationException이 발생하는 모든 예외를 가로챔
    public Map<String, String> validationException(CustomValidationException e) {
        return e.getErrorMap();
    }
}
