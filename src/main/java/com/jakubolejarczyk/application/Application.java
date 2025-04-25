package com.jakubolejarczyk.application;

import com.jakubolejarczyk.infrastructure.ReadOptionService;
import com.jakubolejarczyk.ui.ExitUI;
import com.jakubolejarczyk.ui.MenuUI;
import com.jakubolejarczyk.ui.WrongOptionUI;

public class Application {
    private final MenuUI menuUI;
    private final WrongOptionUI wrongOptionUI;
    private final ExitUI exitUI;
    private final ReadOptionService readOptionService;

    public Application() {
        menuUI = new MenuUI();
        wrongOptionUI = new WrongOptionUI();
        exitUI = new ExitUI();
        readOptionService = new ReadOptionService();
    }

    public void run() {
        while (true) {
            try {
                menuUI.draw();
                int option = readOptionService.read();
                switch (option) {
                    case 0 -> {
                        exitUI.draw();
                        return;
                    }
                    case 1 -> {
                        System.out.println("1");
                    }
                    default -> {
                        wrongOptionUI.draw();
                    }
                };
            } catch (Exception e) {
                throw new Error(e.getMessage());
            }
        }
    }

//    private final ReadPostsService readPostsService;
//    private final PostsDtoBuilder postsDtoBuilder;
//    private final PostsDomainBuilder postsDomainBuilder;
//    private final SavePostsService savePostsService;
//
//    public Application() {
//        this.readPostsService = new ReadPostsService();
//        this.postsDtoBuilder = new PostsDtoBuilder();
//        this.postsDomainBuilder = new PostsDomainBuilder();
//        this.savePostsService = new SavePostsService();
//    }
//
//    public void run() {
//        String posts = readPostsService.readPosts();
//        List<PostDtoModel> postsDto = postsDtoBuilder.build(posts);
//        List<PostDomainModel> postsDomain = postsDomainBuilder.build(postsDto);
//        savePostsService.savePosts(postsDomain);
//    }
}
