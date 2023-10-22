package com.example.demo.model;


import javax.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String blogName;
    private String summary;

    private String content;
    private String author;

    private String timePost;

    public Blog() {
    }

    public Blog(String blogName, String summary, String content, String author, String timePost) {
        this.blogName = blogName;
        this.summary = summary;
        this.content = content;
        this.author = author;
        this.timePost = timePost;
    }

    public Blog(int id, String blogName, String summary, String content, String author, String timePost) {
        this.id = id;
        this.blogName = blogName;
        this.summary = summary;
        this.content = content;
        this.author = author;
        this.timePost = timePost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTimePost() {
        return timePost;
    }

    public void setTimePost(String timePost) {
        this.timePost = timePost;
    }
}
