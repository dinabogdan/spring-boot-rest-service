package com.freesoft.rest.web.service.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Slf4j
@Getter
@Setter
@ToString
@AllArgsConstructor
@ApiModel(description="Some description")
public class User {
    private Integer id;

    @NotNull(message = "Name should not be null.")
    @Size(min = 2, max = 35, message = "Name should have between 2 and 35 chars.")
    @ApiModelProperty(notes="Name should have between 2 and 35 chars.")
    private String name;

    @Past(message = "BirthDate should be in past.")
    @NotNull(message = "BirthDate should not be null.")
    @ApiModelProperty(notes="BirthDate should be in past.")
    private Date birthDate;

    private List<Post> posts;
}
