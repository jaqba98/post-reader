package com.jakubolejarczyk.logic;

import com.jakubolejarczyk.builder.PostsDtoBuilder;
import com.jakubolejarczyk.infrastructure.FetchApiService;
import lombok.AllArgsConstructor;
import lombok.val;

@AllArgsConstructor
public class PostsLogic {
    private final FetchApiService fetchApiService;
    private final PostsDtoBuilder postsDtoBuilder;

    public void run() {
        val api = fetchApiService.fetch("posts");
        val dto = postsDtoBuilder.build(api);
        System.out.println(dto);
    }
}
