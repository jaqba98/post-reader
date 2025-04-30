package com.jakubolejarczyk.infrastructure;

import com.jakubolejarczyk.model.base.BaseModel;
import com.jakubolejarczyk.utils.FileUtils;
import com.jakubolejarczyk.utils.FolderUtils;
import com.jakubolejarczyk.utils.GsonUtils;
import com.jakubolejarczyk.utils.LogUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaveToFileService<TDomain extends BaseModel> {
    @NonNull private final FolderUtils folderUtils;
    @NonNull private final FileUtils<TDomain> fileUtils;
    @NonNull private final GsonUtils<TDomain> gsonUtils;
    @NonNull private final LogUtils logUtils;

    public void save(@NonNull List<TDomain> domains, @NonNull String folderPath) {
        folderUtils.createFolder(folderPath);
        val gson = gsonUtils.create();
        logUtils.emptyLine();
        val files = domains.stream()
            .map(domain -> fileUtils.writeJson(gson, folderPath, domain.getId(), domain))
            .toArray();
        val successLength = Arrays.stream(files).filter(file -> file.equals(true)).toArray().length;
        logUtils.emptyLine();
    }
}
