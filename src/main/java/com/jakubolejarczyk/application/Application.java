package com.jakubolejarczyk.application;

import com.jakubolejarczyk.enums.OptionEnum;
import com.jakubolejarczyk.infrastructure.FetchOptionService;
import com.jakubolejarczyk.logic.PostsLogic;
import com.jakubolejarczyk.ui.ExitUI;
import com.jakubolejarczyk.ui.MenuUI;
import com.jakubolejarczyk.ui.WrongOptionUI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Application {
    @NonNull private final MenuUI menuUI;
    @NonNull private final FetchOptionService fetchOptionService;
    @NonNull private final ExitUI exitUI;
    @NonNull private final WrongOptionUI wrongOptionUI;
    @NonNull private final PostsLogic postsLogic;

    public void start() {
        while(true) {
            menuUI.draw();
            val option = fetchOptionService.fetch();
            if (option == OptionEnum.EXIT) break;
            switch (option) {
                case POSTS -> postsLogic.run();
                case ERROR -> wrongOptionUI.draw();
            }
        }
        exitUI.draw();
    }
}
