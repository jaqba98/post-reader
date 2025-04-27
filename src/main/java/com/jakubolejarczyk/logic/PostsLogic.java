package com.jakubolejarczyk.logic;

import com.jakubolejarczyk.builder.PostsDomainBuilder;
import com.jakubolejarczyk.builder.PostsDtoBuilder;
import com.jakubolejarczyk.enums.OutputEnum;
import com.jakubolejarczyk.infrastructure.FetchApiService;
import com.jakubolejarczyk.infrastructure.SaveToFileService;
import com.jakubolejarczyk.model.domain.PostDomainModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsLogic {
    @NonNull private final FetchApiService fetchApiService;
    @NonNull private final PostsDtoBuilder postsDtoBuilder;
    @NonNull private final PostsDomainBuilder postsDomainBuilder;
    @NonNull private final SaveToFileService<PostDomainModel> saveToFileService;

    public void run() {
        val api = fetchApiService.fetch("posts");
        val dto = postsDtoBuilder.build(api);
        val domain = postsDomainBuilder.build(dto);
        saveToFileService.save(domain, OutputEnum.POSTS.getValue());
    }
}
