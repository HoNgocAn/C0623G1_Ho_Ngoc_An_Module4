package com.example.validatesong.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO {

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

    public SongDTO() {
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
