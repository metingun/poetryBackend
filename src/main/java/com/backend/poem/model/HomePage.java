package com.backend.poem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
}
