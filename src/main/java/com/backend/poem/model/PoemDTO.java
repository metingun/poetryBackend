package com.backend.poem.model;

import java.util.Date;
import java.util.List;

public class PoemDTO {
    private Long id;
    private String poemDetail;
    private String title;
    private String writer;
    private Date date;
    private Long categoryId;
    private List<CommentsDTO> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoemDetail() {
        return poemDetail;
    }

    public void setPoemDetail(String poemDetail) {
        this.poemDetail = poemDetail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<CommentsDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentsDTO> comments) {
        this.comments = comments;
    }
}
