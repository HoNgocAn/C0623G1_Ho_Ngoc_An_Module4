package com.example.books.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long code;

    private Date date;

    public Oder() {
    }

    public Oder(long code, Date date) {
        this.code = code;
        this.date = date;
    }

    public Oder(long id, long code, Date date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
