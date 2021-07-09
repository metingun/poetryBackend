package com.backend.poem.repository;

import com.backend.poem.model.Comments;
import com.backend.poem.model.Poem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Long> {
    List<Comments> findAllByPoemId(Long poemId);
}
