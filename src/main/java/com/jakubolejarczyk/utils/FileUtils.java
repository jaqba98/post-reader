package com.jakubolejarczyk.utils;

import com.google.gson.Gson;
import com.jakubolejarczyk.ui.SaveFileErrorUI;
import com.jakubolejarczyk.ui.SaveFileUI;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.io.FileWriter;

@Service
@AllArgsConstructor
public class FileUtils<TDomain> {
    private final GsonUtils<TDomain> gsonUtils;
    private final SaveFileUI saveFileUI;
    private final SaveFileErrorUI saveFileErrorUI;

    public boolean writeJson(Gson gson, String folderPath, Integer id, TDomain domain) {
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

    private String createJsonFileName(String folderPath, Integer id) {
        return folderPath + "/" + id + ".json";
    }
}
