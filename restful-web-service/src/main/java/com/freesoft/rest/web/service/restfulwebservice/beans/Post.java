package com.freesoft.rest.web.service.restfulwebservice.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@Slf4j
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Post {
    private int postId;
    private String description;
    private Date publishDate;
}
