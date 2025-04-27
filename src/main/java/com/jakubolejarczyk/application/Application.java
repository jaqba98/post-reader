package com.jakubolejarczyk.application;

import com.jakubolejarczyk.enums.OptionEnum;
import com.jakubolejarczyk.infrastructure.FetchOptionService;
import com.jakubolejarczyk.logic.PostsLogic;
import com.jakubolejarczyk.ui.ExitUI;
import com.jakubolejarczyk.ui.MenuUI;
import com.jakubolejarczyk.ui.WrongOptionUI;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Application {
    private final MenuUI menuUI;
    private final FetchOptionService fetchOptionService;
    private final ExitUI exitUI;
    private final WrongOptionUI wrongOptionUI;
    private final PostsLogic postsLogic;

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
