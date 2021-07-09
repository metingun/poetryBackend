package com.backend.poem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long poemId;

    @Column(length = 5000)
    private String comment;

    @Column(length = 500)
    private String interpreter;

    @Column
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPoemId() {
        return poemId;
    }

    public void setPoemId(Long poemId) {
        this.poemId = poemId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getInterpreter() {
        return interpreter;
    }

    public void setInterpreter(String interpreter) {
        this.interpreter = interpreter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
