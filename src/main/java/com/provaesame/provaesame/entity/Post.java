package com.provaesame.provaesame.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String body;
    private int userId;
    public Post() {
    }
    public Post(int id, String title, String body, int userId) {
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
        return "Post [id=" + id + ", title=" + title + ", body=" + body + ", userId=" + userId + "]";
    }
   
    

}
