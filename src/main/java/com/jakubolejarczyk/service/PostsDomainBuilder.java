package com.jakubolejarczyk.service;

import com.jakubolejarczyk.model.domain.PostDomainModel;
import com.jakubolejarczyk.model.dto.PostDtoModel;

import java.util.List;
import java.util.stream.Collectors;

public class PostsDomainBuilder {
    public List<PostDomainModel> build(List<PostDtoModel> postsDto) {
        return postsDto.stream()
            .map(postDto -> PostDomainModel.builder()
                .userId(postDto.getUserId())
                .id(postDto.getId())
                .title(postDto.getTitle())
                .body(postDto.getBody())
                .build())
            .collect(Collectors.toList());
    }
}
