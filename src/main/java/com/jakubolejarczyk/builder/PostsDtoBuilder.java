package com.jakubolejarczyk.builder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jakubolejarczyk.model.dto.PostDtoModel;

import java.lang.reflect.Type;
import java.util.List;

public class PostsDtoBuilder {
    public List<PostDtoModel> build(String input) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<PostDtoModel>>() {}.getType();
        return gson.fromJson(input, listType);
    }
}
