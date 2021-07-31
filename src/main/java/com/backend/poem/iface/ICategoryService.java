package com.backend.poem.iface;

import com.backend.poem.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();

    List<Category> getAllByUserId(Long userId);

    List<Category> getById(Long categoryId);

    Integer add(Category category);

    Integer update(Category category);

    Integer delete(Long id);

}
