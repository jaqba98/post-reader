package com.jakubolejarczyk.application;

import com.jakubolejarczyk.infrastructure.ReadPostsService;
import com.jakubolejarczyk.model.dto.PostDtoModel;
import com.jakubolejarczyk.service.builder.PostDtoBuilder;

import java.util.List;

public class Application {
    private final ReadPostsService readPostsService;
    private final PostDtoBuilder postDtoBuilder;

    public Application() {
        this.readPostsService = new ReadPostsService();
        this.postDtoBuilder = new PostDtoBuilder();
    }

    public void run() {
        String posts = readPostsService.readPosts();
        List<PostDtoModel> postsDto = postDtoBuilder.build(posts);
        postsDto.forEach(postDto -> {
            System.out.println(postDto.getId());
        });
    }
}
