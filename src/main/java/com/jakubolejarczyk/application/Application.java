package com.jakubolejarczyk.application;

import com.jakubolejarczyk.enums.OptionEnum;
import com.jakubolejarczyk.infrastructure.FetchOptionService;
import com.jakubolejarczyk.ui.HrUI;
import com.jakubolejarczyk.ui.MenuUI;
import lombok.AllArgsConstructor;
import lombok.val;

@AllArgsConstructor
public class Application {
    private final MenuUI menuUI;
    private final FetchOptionService fetchOptionService;
    private final HrUI hrUI;

    public void start() {
        while(true) {
            menuUI.draw();
            val option = fetchOptionService.fetch();
            hrUI.draw();
            if (option == OptionEnum.EXIT) break;
        }
    }
}

//    private final ExitUI exitUI;
//    private final WrongOptionUI wrongOptionUI;
//    private final FetchApiService readPostsService;
//    private final PostsDtoBuilder postsDtoBuilder;
//    private final PostsDomainBuilder postsDomainBuilder;
//    private final SaveToFileService saveToFileService;
//    private final SuccessUI successUI;
//
//        exitUI = new ExitUI();
//        wrongOptionUI = new WrongOptionUI();
//        readPostsService = new FetchApiService();
//        postsDtoBuilder = new PostsDtoBuilder();
//        postsDomainBuilder = new PostsDomainBuilder();
//        saveToFileService = new SaveToFileService();
//        successUI = new SuccessUI();
//    }
//
//    public void run() {
//        while (true) {
//            try {
//                menuUI.draw();
//                String option = fetchOptionService.readOption();
//                System.out.println();
//                switch (option) {
//                    case "posts" -> {
//                        String posts = readPostsService.readApi("posts");
//                        List<PostDtoModel> postsDto = postsDtoBuilder.build(posts);
//                        List<PostDomainModel> postsDomain = postsDomainBuilder.build(postsDto);
//                        saveToFileService.savePosts(postsDomain);
//                        successUI.draw("Posts");
//                    }
//                    case "exit" -> {
//                        exitUI.draw();
//                        return;
//                    }
//                    default -> wrongOptionUI.draw();
//                }
//                System.out.println();
//            } catch (Exception e) {
//                throw new Error(e.getMessage());
//            }
//        }
//    }
//}
