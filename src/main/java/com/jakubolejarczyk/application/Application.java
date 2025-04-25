package com.jakubolejarczyk.application;

import com.jakubolejarczyk.infrastructure.ReadOptionService;
import com.jakubolejarczyk.infrastructure.ReadPostsService;
import com.jakubolejarczyk.infrastructure.SavePostsService;
import com.jakubolejarczyk.model.domain.PostDomainModel;
import com.jakubolejarczyk.model.dto.PostDtoModel;
import com.jakubolejarczyk.service.builder.PostsDomainBuilder;
import com.jakubolejarczyk.service.builder.PostsDtoBuilder;
import com.jakubolejarczyk.ui.ExitUI;
import com.jakubolejarczyk.ui.MenuUI;
import com.jakubolejarczyk.ui.WrongOptionUI;

import java.util.List;

public class Application {
    private final MenuUI menuUI;
    private final WrongOptionUI wrongOptionUI;
    private final ExitUI exitUI;
    private final ReadOptionService readOptionService;
    private final ReadPostsService readPostsService;
    private final PostsDtoBuilder postsDtoBuilder;
    private final PostsDomainBuilder postsDomainBuilder;
    private final SavePostsService savePostsService;

    public Application() {
        menuUI = new MenuUI();
        wrongOptionUI = new WrongOptionUI();
        exitUI = new ExitUI();
        readOptionService = new ReadOptionService();
        readPostsService = new ReadPostsService();
        postsDtoBuilder = new PostsDtoBuilder();
        this.postsDomainBuilder = new PostsDomainBuilder();
        this.savePostsService = new SavePostsService();
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
                        String posts = readPostsService.readPosts();
                        List<PostDtoModel> postsDto = postsDtoBuilder.build(posts);
                        List<PostDomainModel> postsDomain = postsDomainBuilder.build(postsDto);
                        savePostsService.savePosts(postsDomain);
                    }
                    default -> wrongOptionUI.draw();
                }
            } catch (Exception e) {
                throw new Error(e.getMessage());
            }
        }
    }
}