package com.jakubolejarczyk.application;

import com.jakubolejarczyk.infrastructure.ReadApiService;
import com.jakubolejarczyk.infrastructure.ReadOptionService;
import com.jakubolejarczyk.infrastructure.SavePostsService;
import com.jakubolejarczyk.model.domain.PostDomainModel;
import com.jakubolejarczyk.model.dto.PostDtoModel;
import com.jakubolejarczyk.service.PostsDomainBuilder;
import com.jakubolejarczyk.service.PostsDtoBuilder;
import com.jakubolejarczyk.ui.ExitUI;
import com.jakubolejarczyk.ui.MenuUI;
import com.jakubolejarczyk.ui.SuccessUI;
import com.jakubolejarczyk.ui.WrongOptionUI;

import java.util.List;

public class Application {
    private final MenuUI menuUI;
    private final ReadOptionService readOptionService;
    private final ExitUI exitUI;
    private final WrongOptionUI wrongOptionUI;
    private final ReadApiService readPostsService;
    private final PostsDtoBuilder postsDtoBuilder;
    private final PostsDomainBuilder postsDomainBuilder;
    private final SavePostsService savePostsService;
    private final SuccessUI successUI;

    public Application() {
        menuUI = new MenuUI();
        readOptionService = new ReadOptionService();
        exitUI = new ExitUI();
        wrongOptionUI = new WrongOptionUI();
        readPostsService = new ReadApiService();
        postsDtoBuilder = new PostsDtoBuilder();
        postsDomainBuilder = new PostsDomainBuilder();
        savePostsService = new SavePostsService();
        successUI = new SuccessUI();
    }

    public void run() {
        while (true) {
            try {
                menuUI.draw();
                String option = readOptionService.readOption();
                System.out.println();
                switch (option) {
                    case "posts" -> {
                        String posts = readPostsService.readApi("posts");
                        List<PostDtoModel> postsDto = postsDtoBuilder.build(posts);
                        List<PostDomainModel> postsDomain = postsDomainBuilder.build(postsDto);
                        savePostsService.savePosts(postsDomain);
                        successUI.draw("Posts");
                    }
                    case "exit" -> {
                        exitUI.draw();
                        return;
                    }
                    default -> wrongOptionUI.draw();
                }
                System.out.println();
            } catch (Exception e) {
                throw new Error(e.getMessage());
            }
        }
    }
}
