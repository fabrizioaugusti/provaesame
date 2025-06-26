package com.provaesame.provaesame.model;

import java.util.Date;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PostDTO {

    private int id;
    @NotBlank(message = "Il campo titolo è obbligatorio")
    @NotNull(message = "Il campo titolo è obbligatorio")
    private String title;
    private String body;
    private int userId;

    public PostDTO() {
    }

    public PostDTO(int id,
            String title,
            String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PostDTO [id=" + id + ", title=" + title + ", body=" + body + ", userId=" + userId + "]";
    }



    

}
