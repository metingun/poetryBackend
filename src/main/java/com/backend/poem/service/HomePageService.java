package com.backend.poem.service;

import com.backend.poem.model.HomePage;
import com.backend.poem.model.Poem;
import com.backend.poem.repository.HomePageRepo;
import com.backend.poem.repository.PoemRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageService {

    private final HomePageRepo homePageRepo;

    public HomePageService(HomePageRepo homePageRepo) {
        this.homePageRepo = homePageRepo;
    }

    public HomePage getHomePage() {
        return homePageRepo.findAll().get(0);
    }

    public String save(HomePage homePage) {
        homePageRepo.save(homePage);
        return "Successful";
    }

}
