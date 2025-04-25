package com.jakubolejarczyk.infrastructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakubolejarczyk.model.domain.PostDomainModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SavePostsService {
    public void savePosts(List<PostDomainModel> postsDomain) {
        File folder = new File("test");
        if (!folder.exists()) {
            folder.mkdir();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        postsDomain.forEach(postDomain -> {
            String json = gson.toJson(postDomain);
            try (FileWriter writer = new FileWriter("test/" + postDomain.getId() + ".json")) {
                writer.write(json);
                System.out.println("Obiekt zapisany do pliku: test/" + postDomain.getId() + ".json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
