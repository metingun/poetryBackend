package com.backend.poem.iface;

import com.backend.poem.model.Poem;
import com.backend.poem.model.PoemDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IPoemService {

    Integer add(Poem poem);

    Integer update(Poem poem);

    Integer delete(Long id);

    List<Poem> getAllByUserId(Long userId);

    List<Poem> getAll();

    List<Poem> getAllByUserIdAndCount(Long userId);

    List<Poem> getAllByCount();

    List<Poem> getPoemsBySearchText(String text);

    List<Poem> getPoemsBySearchTextAndUserId(String text,Long userId);

    List<Poem> getPoemsBySearchTextAndCategoryId(String text,Long categoryId);

    List<Poem> getAllByCategoryId(Long categoryId);

    List<Poem> getAllByCategoryIdAndUserId(Long categoryId,Long userId);

    PoemDTO getById(Long poemId);

    Poem getByIdAndUserId(Long poemId, Long userId);

}
