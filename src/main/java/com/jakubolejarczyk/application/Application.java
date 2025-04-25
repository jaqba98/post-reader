package com.jakubolejarczyk.application;

import com.jakubolejarczyk.infrastructure.ReadPostsService;

public class Application {
    private final ReadPostsService readPostsService;

    public Application() {
        readPostsService = new ReadPostsService();
    }

    public void start() {
        String posts = readPostsService.readPosts();
        System.out.println(posts);
    }
}
