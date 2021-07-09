package com.backend.poem.service;

import com.backend.poem.model.Category;
import com.backend.poem.model.Poem;
import com.backend.poem.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public String save(Category category) {
        categoryRepo.save(category);
        return "Successful";
    }
}
