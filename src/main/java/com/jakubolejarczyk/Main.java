package com.jakubolejarczyk;

import com.jakubolejarczyk.builder.PostsBuilder;
import com.jakubolejarczyk.infrastructure.FetchPostsService;
import com.jakubolejarczyk.infrastructure.SavePostsService;
import com.jakubolejarczyk.model.Post;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FetchPostsService fetchPostsService = new FetchPostsService();
        String input = fetchPostsService.fetch();
        PostsBuilder postsBuilder = new PostsBuilder();
        List<Post> posts = postsBuilder.build(input);
        SavePostsService savePostsService = new SavePostsService();
        savePostsService.save(posts);
    }
}
