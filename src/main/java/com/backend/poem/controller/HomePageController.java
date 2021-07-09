package com.backend.poem.controller;

import com.backend.poem.model.HomePage;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.service.HomePageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/homepage", produces = "application/json")
public class HomePageController {

    private final HomePageService homePageService;

    public HomePageController(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseModel save(@RequestBody HomePage homePage) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(homePageService.save(homePage),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    // HomePage getiren metod
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseModel get() {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(homePageService.getHomePage(),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }
}
