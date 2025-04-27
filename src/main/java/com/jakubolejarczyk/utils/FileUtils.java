package com.jakubolejarczyk.utils;

import com.google.gson.Gson;
import com.jakubolejarczyk.ui.SaveFileUI;
import lombok.AllArgsConstructor;
import lombok.val;

import java.io.FileWriter;

@AllArgsConstructor
public class FileUtils<TDomain> {
    private final GsonUtils<TDomain> gsonUtils;
    private final SaveFileUI saveFileUI;

    public void writeJson(Gson gson, String folderPath, Integer id, TDomain domain) {
        val json = gsonUtils.toJson(gson, domain);
        val filePath = createJsonFileName(folderPath, id);
        try(FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
            saveFileUI.setFile(filePath);
            saveFileUI.draw();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String createJsonFileName(String folderPath, Integer id) {
        return folderPath + "/" + id + ".json";
    }
}
