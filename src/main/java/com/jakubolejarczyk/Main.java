package com.jakubolejarczyk;

import com.jakubolejarczyk.infrastructure.FetchPostsService;

public class Main {
    public static void main(String[] args) {
        FetchPostsService fetchPostsService = new FetchPostsService();
        String posts = fetchPostsService.fetch();
        System.out.println(posts);
    }
}
