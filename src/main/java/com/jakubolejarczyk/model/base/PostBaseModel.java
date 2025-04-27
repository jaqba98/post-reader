package com.jakubolejarczyk.model.base;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class PostBaseModel extends BaseModel {
    private Integer userId;
    private String title;
    private String body;
}
