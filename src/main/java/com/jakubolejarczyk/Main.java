package com.jakubolejarczyk;

import com.jakubolejarczyk.builder.PostsBuilder;
import com.jakubolejarczyk.infrastructure.FetchPostsService;
import com.jakubolejarczyk.infrastructure.SavePostsService;
import com.jakubolejarczyk.model.Post;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FetchPostsService fetchPostsService = new FetchPostsService();
        PostsBuilder postsBuilder = new PostsBuilder();
        SavePostsService savePostsService = new SavePostsService();
        String postsString = fetchPostsService.fetch();
        List<Post> posts = postsBuilder.build(postsString);
        savePostsService.save(posts);
    }
}
