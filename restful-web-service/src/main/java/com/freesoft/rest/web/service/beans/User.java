package com.freesoft.rest.web.service.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@Slf4j
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Date birthDate;
    private List<Post> posts;
}
