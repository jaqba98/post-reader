package com.jakubolejarczyk.service.builder;

import com.jakubolejarczyk.model.domain.PostDomainModel;
import com.jakubolejarczyk.model.dto.PostDtoModel;

import java.util.List;

public class PostDomainBuilder {
    public List<PostDomainModel> build(List<PostDtoModel> postsDto) {
        return postsDto.stream().map(postsDto2 -> {
            PostDomainModel postDomainModel = new PostDomainModel();
            postDomainModel.setUserId(postsDto2.getUserId());
            postDomainModel.setId(postsDto2.getId());
            postDomainModel.setTitle(postsDto2.getTitle());
            postDomainModel.setBody(postsDto2.getBody());
            return postDomainModel;
        }).toList();
    }
}
