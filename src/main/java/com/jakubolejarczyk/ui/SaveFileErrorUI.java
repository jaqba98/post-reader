package com.jakubolejarczyk.ui;

import com.jakubolejarczyk.model.ui.UIModel;
import com.jakubolejarczyk.utils.LogUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveFileErrorUI implements UIModel {
    private final LogUtils logUtils;
    private String fileName;

    public void draw() {
        logUtils.error("The file " + fileName + " has not been saved!");
    }

    public void setFile(String fileName) {
        this.fileName = fileName;
    }
}
