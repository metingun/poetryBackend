package com.backend.poem.controller;

import com.backend.poem.iface.IHomePageService;
import com.backend.poem.model.HomePage;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.service.HomePageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/homepage", produces = "application/json")
public class HomePageController {

    private final IHomePageService homePageService;

    public HomePageController(IHomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseModel add(@RequestBody HomePage homePage) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(homePageService.add(homePage),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseModel update(@RequestBody HomePage homePage) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(homePageService.update(homePage),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    // HomePage getiren metod
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseModel get() {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(homePageService.get(),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }
}
