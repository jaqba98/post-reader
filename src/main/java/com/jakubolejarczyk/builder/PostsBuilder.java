package com.jakubolejarczyk.builder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jakubolejarczyk.model.Post;

import java.util.List;

public class PostsBuilder {
    public List<Post> build(String input) {
        Gson gson = new Gson();
        return gson.fromJson(input, new TypeToken<List<Post>>(){}.getType());
    }
}
