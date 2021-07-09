package com.backend.poem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Poem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10000)
    private String poemDetail;

    @Column(length = 500)
    private String title;

    @Column(length = 500)
    private String writer;

    @Column
    private Date date;

    @Column
    private Long categoryId;

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
}
