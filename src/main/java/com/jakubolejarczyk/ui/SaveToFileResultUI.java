package com.jakubolejarczyk.ui;

import com.jakubolejarczyk.model.ui.UIModel;
import com.jakubolejarczyk.utils.LogUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveToFileResultUI implements UIModel {
    @NonNull private final LogUtils logUtils;
    private Integer successLength;
    private Integer fullLength;

    public void draw() {
        if (successLength.equals(fullLength)) {
            logUtils.success("Success: All files have been processed correctly!");
            return;
        }
        logUtils.error("Error: Only " + successLength + " out of " + fullLength + " files were saved correctly.");
    }

    public void setData(@NonNull Integer successLength, @NonNull Integer fullLength) {
        this.successLength = successLength;
        this.fullLength = fullLength;
    }
}
