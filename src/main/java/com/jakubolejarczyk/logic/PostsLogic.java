package com.jakubolejarczyk.logic;

import com.jakubolejarczyk.builder.PostsDomainBuilder;
import com.jakubolejarczyk.builder.PostsDtoBuilder;
import com.jakubolejarczyk.infrastructure.FetchApiService;
import lombok.AllArgsConstructor;
import lombok.val;

@AllArgsConstructor
public class PostsLogic {
    private final FetchApiService fetchApiService;
    private final PostsDtoBuilder postsDtoBuilder;
    private final PostsDomainBuilder postsDomainBuilder;

    public void run() {
        val api = fetchApiService.fetch("posts");
        val dto = postsDtoBuilder.build(api);
        val domain = postsDomainBuilder.build(dto);
        System.out.println(domain);
    }
}
