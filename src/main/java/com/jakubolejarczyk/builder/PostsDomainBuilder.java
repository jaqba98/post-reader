package com.jakubolejarczyk.builder;

import com.jakubolejarczyk.model.Post;
import com.jakubolejarczyk.model.dto.PostDtoModel;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsDomainBuilder {
    public List<Post> build(@NonNull List<PostDtoModel> postsDto) {
        return postsDto.stream()
            .map(postDto -> Post.builder()
                .userId(postDto.getUserId())
                .id(postDto.getId())
                .title(postDto.getTitle())
                .body(postDto.getBody())
                .build())
            .collect(Collectors.toList());
    }
}
