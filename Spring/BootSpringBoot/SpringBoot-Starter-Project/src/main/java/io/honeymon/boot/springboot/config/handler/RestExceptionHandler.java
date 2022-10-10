package io.honeymon.boot.springboot.config.handler;

import io.honeymon.boot.springboot.api.HelloController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RestControllerAdvice(basePackageClasses = HelloController.class)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<?> handleControllerException(Throwable ex) {
        String response = String.format("예상치 못한 에러가 발생했습니다. 이유 : [%s]", ex.getMessage());

        log.info("response 값 : [{}]", response);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));
        HttpEntity<?> entity = new HttpEntity<>(response, header);
        return ResponseEntity.ok(Optional.ofNullable(entity.getBody()));
    }

//    private HttpStatus getStatus(HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if(statusCode == null) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//
//        return HttpStatus.valueOf(statusCode);
//
//    }
}
