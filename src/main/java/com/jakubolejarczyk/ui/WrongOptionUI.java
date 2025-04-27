package com.jakubolejarczyk.ui;

import com.jakubolejarczyk.model.ui.UIModel;
import com.jakubolejarczyk.utils.LogUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WrongOptionUI implements UIModel {
    private final LogUtils logUtils;

    public void draw() {
        logUtils.emptyLine();
        logUtils.error("--------------------------------------------------");
        logUtils.error("ERROR: You entered an incorrect option. Try again!");
        logUtils.error("--------------------------------------------------");
        logUtils.emptyLine();
    }
}
