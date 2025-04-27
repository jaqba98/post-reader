package com.jakubolejarczyk.ui;

import com.jakubolejarczyk.model.ui.UIModel;
import com.jakubolejarczyk.utils.LogUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MenuUI implements UIModel {
    private final LogUtils logUtils;

    public void draw() {
        logUtils.info("##################################################");
        logUtils.info("#      POST READER v0.1 by Jakub Olejarczyk      #");
        logUtils.info("##################################################");
        logUtils.info("1) Posts");
        logUtils.info("0) Exit program");
        logUtils.info("Select API to load: ", false);
    }
}
