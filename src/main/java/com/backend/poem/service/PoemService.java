package com.backend.poem.service;

import com.backend.poem.model.HomePage;
import com.backend.poem.model.Poem;
import com.backend.poem.model.PoemDTO;
import com.backend.poem.repository.PoemRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoemService {

    private final PoemRepo poemRepo;
    private final CommentService commentService;

    public PoemService(PoemRepo poemRepo,CommentService commentService) {
        this.poemRepo = poemRepo;
        this.commentService = commentService;
    }

    public List<Poem> getPoemsByCategoryId(Long categoryId) {
        return poemRepo.findAllByCategoryId(categoryId);
    }

    public PoemDTO getById(Long id) {
        Poem poem=poemRepo.getById(id);
        PoemDTO poemDTO=new PoemDTO();
        BeanUtils.copyProperties(poem,poemDTO);
        poemDTO.setComments(commentService.getCommentsByPoemId(id));
        return poemDTO;
    }

    public String save(Poem poem) {
        poemRepo.save(poem);
        return "Successful";
    }
}
