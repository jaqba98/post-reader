package com.jakubolejarczyk.utils;

import lombok.val;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FolderUtils {
    public void createFolder(String folderPath) {
        val folder = new File(folderPath);
        if (folder.exists()) {
            return;
        }
        folder.mkdir();
    }
}
