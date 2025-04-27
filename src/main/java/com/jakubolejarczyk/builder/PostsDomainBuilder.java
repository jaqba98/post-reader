package com.jakubolejarczyk.builder;

import com.jakubolejarczyk.model.domain.PostDomainModel;
import com.jakubolejarczyk.model.dto.PostDtoModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
