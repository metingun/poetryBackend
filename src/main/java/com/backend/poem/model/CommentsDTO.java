package com.backend.poem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentsDTO {
    private Long id;
    private Long poemId;
    private String comment;
    private String interpreter;
    private Date date;
}
