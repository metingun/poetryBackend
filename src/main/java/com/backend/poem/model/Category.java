package com.backend.poem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String pictureLink;

    @Column(length = 500)
    private String categoryName;

    @Column(length = 500)
    private String description;
}
