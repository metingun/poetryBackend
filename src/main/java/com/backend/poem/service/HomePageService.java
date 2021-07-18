package com.backend.poem.service;

import com.backend.poem.iface.IHomePageService;
import com.backend.poem.model.HomePage;
import com.backend.poem.model.Poem;
import com.backend.poem.repository.HomePageRepo;
import com.backend.poem.repository.PoemRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageService implements IHomePageService {

    private final HomePageRepo homePageRepo;

    public HomePageService(HomePageRepo homePageRepo) {
        this.homePageRepo = homePageRepo;
    }

    @Override
    public HomePage get() {
        return homePageRepo.findAll().get(0);
    }

    @Override
    public Integer add(HomePage homePage) {
        homePageRepo.save(homePage);
        return 200;
    }

    @Override
    public Integer update(HomePage homePage) {
        homePageRepo.save(homePage);
        return 200;
    }
}
