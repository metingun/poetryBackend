package com.backend.poem.service;

import com.backend.poem.iface.ICommentService;
import com.backend.poem.model.Comments;
import com.backend.poem.model.CommentsDTO;
import com.backend.poem.model.Poem;
import com.backend.poem.repository.CommentRepo;
import com.backend.poem.repository.PoemRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CommentService implements ICommentService {

    private final CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public Integer doComment(CommentsDTO commentsDTO) {
        commentsDTO.setDate(new Date());
        Comments comments=new Comments();
        BeanUtils.copyProperties(commentsDTO,comments);
        commentRepo.save(comments);
        return 200;
    }

    @Override
    public List<CommentsDTO> getCommentsByPoemId(Long poemId) {
        List<Comments> comments= commentRepo.findAllByPoemIdOrderByIdDesc(poemId);
        List<CommentsDTO> commentsDTOS=new ArrayList<>();
        for (Comments comment:comments) {
            CommentsDTO commentsDTO=new CommentsDTO();
            BeanUtils.copyProperties(comment,commentsDTO);
            commentsDTOS.add(commentsDTO);
        }
        return commentsDTOS;
    }
}
