package com.backend.poem.model;

import javax.persistence.*;

@Entity
public class HomePage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String letter1;

    @Column(length = 500)
    private String letter2;

    @Column(length = 500)
    private String letter3;

    @Column(length = 500)
    private String bigLetter;

    @Column(length = 500)
    private String pictureHomePage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLetter1() {
        return letter1;
    }

    public void setLetter1(String letter1) {
        this.letter1 = letter1;
    }

    public String getLetter2() {
        return letter2;
    }

    public void setLetter2(String letter2) {
        this.letter2 = letter2;
    }

    public String getLetter3() {
        return letter3;
    }

    public void setLetter3(String letter3) {
        this.letter3 = letter3;
    }

    public String getBigLetter() {
        return bigLetter;
    }

    public void setBigLetter(String bigLetter) {
        this.bigLetter = bigLetter;
    }

    public String getPictureHomePage() {
        return pictureHomePage;
    }

    public void setPictureHomePage(String pictureHomePage) {
        this.pictureHomePage = pictureHomePage;
    }
}
