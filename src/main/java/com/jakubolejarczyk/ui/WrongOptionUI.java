package com.jakubolejarczyk.ui;

import com.jakubolejarczyk.model.ui.UIModel;
import com.jakubolejarczyk.utils.LogUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WrongOptionUI implements UIModel {
    @NonNull private final LogUtils logUtils;

    public void draw() {
        logUtils.emptyLine();
        logUtils.error("--------------------------------------------------");
        logUtils.error("ERROR: You entered an incorrect option. Try again!");
        logUtils.error("--------------------------------------------------");
        logUtils.emptyLine();
    }
}
