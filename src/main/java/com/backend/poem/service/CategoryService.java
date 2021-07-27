package com.backend.poem.service;

import com.backend.poem.iface.ICategoryService;
import com.backend.poem.model.Category;
import com.backend.poem.model.Poem;
import com.backend.poem.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public List<Category> getById(Long categoryId) {
        return categoryRepo.getById(categoryId);
    }

    @Override
    public Integer add(Category category) {
        categoryRepo.save(category);
        return 200;
    }

    @Override
    public Integer update(Category category) {
        categoryRepo.save(category);
        return 200;
    }

    @Override
    public Integer delete(Long id) {
        categoryRepo.deleteById(id);
        return 200;
    }
}
