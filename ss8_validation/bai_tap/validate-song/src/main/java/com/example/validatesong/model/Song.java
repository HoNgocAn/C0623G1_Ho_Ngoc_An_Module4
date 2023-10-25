package com.example.validatesong.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "{error.name.empty}")
    @Size(max =800 , message = "Do not enter more than 800 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,}$", message = "{error.name.pattern}")
    private String name;

    @NotEmpty (message = "{error.name.empty}")
    @Size(max =300,message = "Do not enter more than 300 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,}$" , message = "{error.name.pattern}")
    private String singer;

    @NotEmpty (message = "{error.name.empty}")
    @Size(max =1000 ,message = "Do not enter more than 1000 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 \\,]{1,}$" , message = "{error.name.pattern}")
    private String type;

    public Song() {
    }

    public Song( @NotEmpty @Size(max =800) String name, @NotEmpty @Size(max =300) String singer, @NotEmpty @Size(max =1000) String type) {
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
