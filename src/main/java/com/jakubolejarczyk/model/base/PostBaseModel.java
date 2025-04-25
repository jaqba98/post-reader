package com.jakubolejarczyk.model.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class PostBaseModel {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
