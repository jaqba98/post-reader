package com.jakubolejarczyk.infrastructure;

import com.jakubolejarczyk.model.Post;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SavePostsService {
    public void save(List<Post> posts) {
        File folder = new File("posts");
        if (!folder.exists()) {
            folder.mkdir();
        }
        posts.forEach(post -> {
            try(FileWriter writer = new FileWriter("posts/" + post.getId() + ".json")) {
                writer.write(post.toString());
            } catch (NullPointerException e) {
                e.getLocalizedMessage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
