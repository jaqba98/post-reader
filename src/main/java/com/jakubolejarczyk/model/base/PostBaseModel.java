package com.jakubolejarczyk.model.base;

public class PostBaseModel {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public static class Builder {
        private Integer userId;
        private Integer id;
        private String title;
        private String body;

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public PostBaseModel build() {
            PostBaseModel postBaseModel = new PostBaseModel();
            postBaseModel.userId = this.userId;
            postBaseModel.id = this.id;
            postBaseModel.title = this.title;
            postBaseModel.body = body;
            return postBaseModel;
        }
    }
}
