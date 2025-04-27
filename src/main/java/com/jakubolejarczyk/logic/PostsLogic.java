package com.jakubolejarczyk.logic;

import com.jakubolejarczyk.infrastructure.FetchApiService;
import lombok.AllArgsConstructor;
import lombok.val;

@AllArgsConstructor
public class PostsLogic {
    private final FetchApiService fetchApiService;

    public void run() {
        val api = fetchApiService.fetch("posts");
        System.out.println(api);
    }
}
