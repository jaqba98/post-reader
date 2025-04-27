package com.jakubolejarczyk.infrastructure;

import com.jakubolejarczyk.model.base.BaseModel;
import com.jakubolejarczyk.ui.SaveToFileResultUI;
import com.jakubolejarczyk.utils.FileUtils;
import com.jakubolejarczyk.utils.FolderUtils;
import com.jakubolejarczyk.utils.GsonUtils;
import com.jakubolejarczyk.utils.LogUtils;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class SaveToFileService<TDomain extends BaseModel> {
    private final FolderUtils folderUtils;
    private final FileUtils<TDomain> fileUtils;
    private final GsonUtils<TDomain> gsonUtils;
    private final LogUtils logUtils;
    private final SaveToFileResultUI saveToFileResultUI;

    public void save(List<TDomain> domains, String folderPath) {
        folderUtils.createFolder(folderPath);
        val gson = gsonUtils.create();
        logUtils.emptyLine();
        val files = domains.stream()
            .map(domain -> fileUtils.writeJson(gson, folderPath, domain.getId(), domain))
            .toArray();
        val successLength = Arrays.stream(files).filter(file -> file.equals(true)).toArray().length;
        saveToFileResultUI.setData(successLength, files.length);
        saveToFileResultUI.draw();
        logUtils.emptyLine();
    }
}
