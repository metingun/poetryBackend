package com.backend.poem.model;

import java.util.Date;

public class CommentsDTO {
    private Long id;
    private Long poemId;
    private String comment;
    private String interpreter;
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
