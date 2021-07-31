package com.backend.poem.repository;

import com.backend.poem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAllByUsername(String username);

    User findAllByUsernameAndPassword(String username,String password);

    User findByUsername(String username);
}
