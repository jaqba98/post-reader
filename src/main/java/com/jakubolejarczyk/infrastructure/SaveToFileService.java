package com.jakubolejarczyk.infrastructure;

import com.jakubolejarczyk.model.base.BaseModel;
import com.jakubolejarczyk.utils.FileUtils;
import com.jakubolejarczyk.utils.FolderUtils;
import com.jakubolejarczyk.utils.GsonUtils;
import lombok.AllArgsConstructor;
import lombok.val;

import java.util.List;

@AllArgsConstructor
public class SaveToFileService<TDomain extends BaseModel> {
    private final FolderUtils folderUtils;
    private final FileUtils<TDomain> fileUtils;
    private final GsonUtils<TDomain> gsonUtils;

    public void save(List<TDomain> domains, String folderPath) {
        folderUtils.createFolder(folderPath);
        val gson = gsonUtils.create();
        domains.forEach(domain -> fileUtils.writeJson(gson, folderPath, domain.getId(), domain));
    }
}
