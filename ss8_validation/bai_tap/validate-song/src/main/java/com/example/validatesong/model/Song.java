package com.example.validatesong.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(max =800)
    private String name;

    @NotEmpty
    @Size(max =300)
    private String singer;

    @NotEmpty
    @Size(max =1000)
    private String type;

    public Song() {
    }

    public Song( @NotEmpty@Size(max =800) String name, @NotEmpty @Size(max =300) String singer, @NotEmpty @Size(max =1000) String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
