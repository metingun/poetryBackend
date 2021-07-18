package com.backend.poem.iface;

import com.backend.poem.model.CommentsDTO;

import java.util.List;

public interface ICommentService {

    Integer doComment(CommentsDTO commentsDTO);

    List<CommentsDTO> getCommentsByPoemId(Long poemId);

}
