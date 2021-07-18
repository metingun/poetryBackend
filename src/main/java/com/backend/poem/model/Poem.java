package com.backend.poem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
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

    @Column
    private Long userId;
}
