package com.backend.poem.repository;

import com.backend.poem.model.Comments;
import com.backend.poem.model.Poem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Long> {

    @Query("from Comments where poemId = :poemId order by id desc")
    List<Comments> findAllByPoemIdOrderByIdDesc(@Param("poemId") Long poemId);
}
