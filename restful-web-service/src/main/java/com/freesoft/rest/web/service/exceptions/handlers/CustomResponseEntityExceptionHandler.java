package com.freesoft.rest.web.service.exceptions.handlers;

import com.freesoft.rest.web.service.beans.ExceptionResponse;
import com.freesoft.rest.web.service.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    private final ResponseEntity handleAllExceptions(Exception exception, WebRequest request) {
        log.error("### Some EXCEPTION!!!");
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(),
                        exception.getMessage(),
                        request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    private final ResponseEntity handleUserNotFoundException
            (UserNotFoundException userNotFoundException, WebRequest request) {
        log.error("### Some UserNotFoundEXCEPTION!!!");
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(),
                        userNotFoundException.getMessage(),
                        request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("### Some Exception!!! Something invalid on the object!");
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                "Validation failed!",
                ex.getBindingResult().toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
