package com.jakubolejarczyk.logic;

import com.jakubolejarczyk.builder.PostsDomainBuilder;
import com.jakubolejarczyk.builder.PostsDtoBuilder;
import com.jakubolejarczyk.enums.OutputEnum;
import com.jakubolejarczyk.infrastructure.FetchApiService;
import com.jakubolejarczyk.infrastructure.SaveToFileService;
import com.jakubolejarczyk.model.domain.PostDomainModel;
import lombok.AllArgsConstructor;
import lombok.val;

@AllArgsConstructor
public class PostsLogic {
    private final FetchApiService fetchApiService;
    private final PostsDtoBuilder postsDtoBuilder;
    private final PostsDomainBuilder postsDomainBuilder;
    private final SaveToFileService<PostDomainModel> saveToFileService;

    public void run() {
        val api = fetchApiService.fetch("posts");
        val dto = postsDtoBuilder.build(api);
        val domain = postsDomainBuilder.build(dto);
        saveToFileService.save(domain, OutputEnum.POSTS.getValue());
    }
}
