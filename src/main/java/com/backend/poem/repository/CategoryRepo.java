package com.backend.poem.repository;

import com.backend.poem.model.Category;
import com.backend.poem.model.Poem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findAll();

    void deleteById(Long id);

    List<Category> getById(Long categoryId);
}
