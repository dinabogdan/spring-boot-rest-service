package com.freesoft.rest.web.service.restfulwebservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Slf4j
@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    private final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        log.error("### Some EXCEPTION!!!");
        ResponseException exceptionResponse =
                new ResponseException(new Date(),
                        exception.getMessage(),
                        request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    private final ResponseEntity<Object> handleUserNotFoundException
            (UserNotFoundException userNotFoundException, WebRequest request) {
        log.error("### Some UserNotFoundEXCEPTION!!!");
        ResponseException exceptionResponse =
                new ResponseException(new Date(),
                        userNotFoundException.getMessage(),
                        request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
