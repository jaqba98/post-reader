//package com.jakubolejarczyk.builder;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.jakubolejarczyk.model.dto.PostDtoModel;
//import lombok.NonNull;
//import org.springframework.stereotype.Service;
//
//import java.lang.reflect.Type;
//import java.util.List;
//
//@Service
//public class PostsDtoBuilder {
//    public List<PostDtoModel> build(@NonNull String input) {
//        Gson gson = new Gson();
//        Type listType = new TypeToken<List<PostDtoModel>>() {}.getType();
//        return gson.fromJson(input, listType);
//    }
//}
