package com.jakubolejarczyk.utils;

import lombok.val;

import java.io.File;

public class FolderUtils {
    public void createFolder(String folderPath) {
        val folder = new File(folderPath);
        if (folder.exists()) {
            return;
        }
        folder.mkdir();
    }
}
