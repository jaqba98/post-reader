package com.jakubolejarczyk.utils;

import com.google.gson.Gson;
import com.jakubolejarczyk.ui.SaveFileErrorUI;
import com.jakubolejarczyk.ui.SaveFileUI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.io.FileWriter;

@Service
@RequiredArgsConstructor
public class FileUtils<TDomain> {
    @NonNull private final GsonUtils<TDomain> gsonUtils;
    @NonNull private final SaveFileUI saveFileUI;
    @NonNull private final SaveFileErrorUI saveFileErrorUI;

    public boolean writeJson(@NonNull Gson gson, @NonNull String folderPath, @NonNull Integer id, @NonNull TDomain domain) {
        val json = gsonUtils.toJson(gson, domain);
        val filePath = createJsonFileName(folderPath, id);
        try(FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
            saveFileUI.setFile(filePath);
            saveFileUI.draw();
            return true;
        } catch (Exception e) {
            saveFileErrorUI.setFile(filePath);
            saveFileErrorUI.draw();
            return false;
        }
    }

    private String createJsonFileName(@NonNull String folderPath, @NonNull Integer id) {
        return folderPath + "/" + id + ".json";
    }
}
