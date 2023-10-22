package com.example.demo.model;


import javax.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String summary;

    private String content;
    private String author;

    private String timePost;


    public Blog() {
    }

    public Blog(String name, String summary, String content, String author, String timePost) {
        this.name = name;
        this.summary = summary;
        this.content = content;
        this.author = author;
        this.timePost = timePost;
    }

    public Blog(Integer id, String name, String summary, String content, String author, String timePost) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.content = content;
        this.author = author;
        this.timePost = timePost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
