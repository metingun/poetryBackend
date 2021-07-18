package com.backend.poem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
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

}
