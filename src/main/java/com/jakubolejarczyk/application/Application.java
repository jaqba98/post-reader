package com.jakubolejarczyk.application;

import com.jakubolejarczyk.infrastructure.ReadPostsService;
import com.jakubolejarczyk.infrastructure.SavePostsService;
import com.jakubolejarczyk.model.domain.PostDomainModel;
import com.jakubolejarczyk.model.dto.PostDtoModel;
import com.jakubolejarczyk.service.builder.PostsDomainBuilder;
import com.jakubolejarczyk.service.builder.PostsDtoBuilder;

import java.util.List;

public class Application {
    private final ReadPostsService readPostsService;
    private final PostsDtoBuilder postsDtoBuilder;
    private final PostsDomainBuilder postsDomainBuilder;
    private final SavePostsService savePostsService;

    public Application() {
        this.readPostsService = new ReadPostsService();
        this.postsDtoBuilder = new PostsDtoBuilder();
        this.postsDomainBuilder = new PostsDomainBuilder();
        this.savePostsService = new SavePostsService();
    }

    public void run() {
        String posts = readPostsService.readPosts();
        List<PostDtoModel> postsDto = postsDtoBuilder.build(posts);
        List<PostDomainModel> postsDomain = postsDomainBuilder.build(postsDto);
        savePostsService.savePosts(postsDomain);
    }
}
