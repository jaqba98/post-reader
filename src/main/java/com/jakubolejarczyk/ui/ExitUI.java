package com.jakubolejarczyk.ui;

import com.jakubolejarczyk.model.ui.UIModel;
import com.jakubolejarczyk.utils.LogUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExitUI implements UIModel {
    private final LogUtils logUtils;

    public void draw() {
        logUtils.emptyLine();
        logUtils.info("--------------------------------------------------");
        logUtils.info("The work is done. Goodbye!");
        logUtils.info("--------------------------------------------------");
        logUtils.emptyLine();
    }
}
