package com.jakubolejarczyk.application;

import com.jakubolejarczyk.infrastructure.ReadPostsService;
import com.jakubolejarczyk.model.domain.PostDomainModel;
import com.jakubolejarczyk.model.dto.PostDtoModel;
import com.jakubolejarczyk.service.builder.PostDomainBuilder;
import com.jakubolejarczyk.service.builder.PostDtoBuilder;

import java.util.List;

public class Application {
    private final ReadPostsService readPostsService;
    private final PostDtoBuilder postDtoBuilder;
    private final PostDomainBuilder postDomainBuilder;

    public Application() {
        this.readPostsService = new ReadPostsService();
        this.postDtoBuilder = new PostDtoBuilder();
        this.postDomainBuilder = new PostDomainBuilder();
    }

    public void run() {
        String posts = readPostsService.readPosts();
        List<PostDtoModel> postsDto = postDtoBuilder.build(posts);
        List<PostDomainModel> postsDomain = postDomainBuilder.build(postsDto);
        postsDomain.forEach(postDomain -> {
            System.out.println(postDomain.getBody());
        });
    }
}
