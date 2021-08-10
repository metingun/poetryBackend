package com.backend.poem.repository;

import com.backend.poem.model.Poem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("from Poem")
    List<Poem> findAllWithPage(Pageable pageable);

    List<Poem> findByTitleContainingIgnoreCaseOrPoemDetailContainingIgnoreCaseOrWriterContainingIgnoreCase(String a,String b,String c);

/*
    List<Poem> findByCategoryIdAndTitleContainingIgnoreCaseOrPoemDetailContainingIgnoreCaseOrWriterContainingIgnoreCase(Long categoryId,String a,String b,String c);
*/

    @Query("from Poem where (lower(title) like lower(CONCAT('%',:text,'%')) or lower(poemDetail) like " +
            "lower(CONCAT('%',:text,'%')) or lower(writer) like lower(CONCAT('%',:text,'%'))) and categoryId = :categoryId")
    List<Poem> searchByCategory(@Param("text") String text,@Param("categoryId") Long categoryId);

    @Query("from Poem where (lower(title) like lower(CONCAT('%',:text,'%')) or lower(poemDetail) like " +
            "lower(CONCAT('%',:text,'%')) or lower(writer) like lower(CONCAT('%',:text,'%'))) and userId = :userId")
    List<Poem> searchByTextAndUserId(@Param("text") String text,@Param("userId") Long userId);
}
