package com.freesoft.rest.web.service.restfulwebservice.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Slf4j
public class User {
    private Integer id;
    private String name;
    private Date birthDate;
}
