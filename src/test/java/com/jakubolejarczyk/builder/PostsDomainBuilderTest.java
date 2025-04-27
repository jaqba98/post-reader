package com.jakubolejarczyk.builder;

import com.jakubolejarczyk.model.domain.PostDomainModel;
import com.jakubolejarczyk.model.dto.PostDtoModel;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostsDomainBuilderTest {
    @Test
    public void build() {
        List<PostDtoModel> dto = List.of(
            PostDtoModel.builder().userId(1).id(1).title("1").body("111").build(),
            PostDtoModel.builder().userId(2).id(2).title("2").body("222").build()
        );
        List<PostDomainModel> domain = List.of(
            PostDomainModel.builder().userId(1).id(1).title("1").body("111").build(),
            PostDomainModel.builder().userId(2).id(2).title("2").body("222").build()
        );
        val postsDomainBuilder = new PostsDomainBuilder();
        val result = postsDomainBuilder.build(dto);
        assertEquals(domain, result, "Should correctly build domain model");
    }
}
