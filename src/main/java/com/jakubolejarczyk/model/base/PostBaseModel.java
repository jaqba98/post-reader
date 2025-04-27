package com.jakubolejarczyk.model.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostBaseModel {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
