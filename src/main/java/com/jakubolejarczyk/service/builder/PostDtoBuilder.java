package com.jakubolejarczyk.service.builder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jakubolejarczyk.model.dto.PostDtoModel;

import java.lang.reflect.Type;
import java.util.List;

public class PostDtoBuilder {
    public List<PostDtoModel> build(String posts) {
        Gson gson = new Gson();
        Type postListType = new TypeToken<List<PostDtoModel>>() {}.getType();
        return gson.fromJson(posts, postListType);
    }
}
