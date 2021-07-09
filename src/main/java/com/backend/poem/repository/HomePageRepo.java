package com.backend.poem.repository;

import com.backend.poem.model.HomePage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomePageRepo extends JpaRepository<HomePage, Long> {
    List<HomePage> findAll();
}
