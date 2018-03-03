package com.freesoft.rest.web.service.restfulwebservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ResponseException {

    private Date timestamp;
    private String message;
    private String details;

}
