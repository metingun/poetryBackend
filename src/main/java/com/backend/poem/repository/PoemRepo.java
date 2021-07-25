package com.backend.poem.repository;

import com.backend.poem.model.Poem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoemRepo extends JpaRepository<Poem, Long> {
    List<Poem> findAllByCategoryId(Long categoryId);

    Poem getById(Long id);

    Poem getByIdAndUserId(Long id,Long userId);

    void deleteById(Long id);

    List<Poem> getAllByUserId(Long userId);

    List<Poem> getTop10ByUserId(Long userId);
}
