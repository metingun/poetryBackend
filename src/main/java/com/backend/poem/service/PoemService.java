package com.backend.poem.service;

import com.backend.poem.iface.ICategoryService;
import com.backend.poem.iface.ICommentService;
import com.backend.poem.iface.IPoemService;
import com.backend.poem.model.HomePage;
import com.backend.poem.model.Poem;
import com.backend.poem.model.PoemDTO;
import com.backend.poem.repository.PoemRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoemService implements IPoemService {

    private final PoemRepo poemRepo;
    private final ICommentService commentService;
    private final ICategoryService categoryService;

    public PoemService(PoemRepo poemRepo, ICommentService commentService, ICategoryService categoryService) {
        this.poemRepo = poemRepo;
        this.commentService = commentService;
        this.categoryService = categoryService;
    }

    @Override
    public Integer add(Poem poem) {
        String link= categoryService.getById(poem.getCategoryId()).get(0).getPictureLink();
        poem.setPictureLink(link);
        poemRepo.save(poem);
        return 200;
    }

    @Override
    public Integer update(Poem poem) {
        String link= categoryService.getById(poem.getCategoryId()).get(0).getPictureLink();
        poem.setPictureLink(link);
        poemRepo.save(poem);
        return 200;
    }

    @Override
    public Integer delete(Long id) {
        poemRepo.deleteById(id);
        return 200;
    }

    @Override
    public List<Poem> getAllByUserId(Long userId) {
        return poemRepo.getAllByUserId(userId);
    }

    @Override
    public List<Poem> getAllByUserIdAndCount(Long userId) {
        return poemRepo.getTop10ByUserId(userId);
    }

    @Override
    public List<Poem> getAllByCategoryId(Long categoryId) {
        return poemRepo.findAllByCategoryId(categoryId);
    }

    @Override
    public PoemDTO getById(Long poemId) {
        Poem poem=poemRepo.getById(poemId);
        PoemDTO poemDTO=new PoemDTO();
        BeanUtils.copyProperties(poem,poemDTO);
        poemDTO.setComments(commentService.getCommentsByPoemId(poemId));
        return poemDTO;
    }

    @Override
    public Poem getByIdAndUserId(Long poemId, Long userId) {
        return poemRepo.getByIdAndUserId(poemId,userId);
    }
}
