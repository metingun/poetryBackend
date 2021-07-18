package com.backend.poem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PoemDTO {
    private Long id;
    private String poemDetail;
    private String title;
    private String writer;
    private Date date;
    private Long categoryId;
    private List<CommentsDTO> comments;
}
