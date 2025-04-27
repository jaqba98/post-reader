package com.jakubolejarczyk.model.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Data
public class BaseModel {
    private Integer id;
}
