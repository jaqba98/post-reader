package com.jakubolejarczyk.model;

public class Post {
    private final Integer userId;
    private final Integer id;
    private final String title;
    private final String body;

    public Post(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
            "\t" + "\"" + "userId\": " + userId + ",\n" +
            "\t" + "\"" + "id\": " + id + ",\n" +
            "\t" + "\"" + "title\": \"" + title.replaceAll("[\\n\\r]", "") + "\"" + ",\n" +
            "\t" + "\"" + "body\": \"" + body.replaceAll("[\\n\\r]", "") + "\"" + "\n" +
            "}";
    }
}
