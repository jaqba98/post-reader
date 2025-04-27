package com.jakubolejarczyk.ui;

import com.jakubolejarczyk.model.ui.UIModel;
import com.jakubolejarczyk.utils.LogUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveFileUI implements UIModel {
    @NonNull private final LogUtils logUtils;
    private String fileName;

    public void draw() {
        logUtils.task("The file " + fileName + " has been saved!");
    }

    public void setFile(@NonNull String fileName) {
        this.fileName = fileName;
    }
}
