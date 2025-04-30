package com.jakubolejarczyk.application;

import com.jakubolejarczyk.logic.PostsLogic;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Application {
    @NonNull private final PostsLogic postsLogic;

    public void start() {
        postsLogic.run();
    }
}
