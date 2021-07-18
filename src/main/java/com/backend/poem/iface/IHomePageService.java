package com.backend.poem.iface;

import com.backend.poem.model.HomePage;

public interface IHomePageService {

    HomePage get();

    Integer add(HomePage homePage);

    Integer update(HomePage homePage);
}
