package com.backend.poem.controller;

import com.backend.poem.iface.IPoemService;
import com.backend.poem.model.Poem;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.service.PoemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/poem", produces = "application/json")
public class PoemController {

    private final IPoemService poemService;

    public PoemController(IPoemService poemService) {
        this.poemService = poemService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseModel add(@RequestBody Poem poem) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.add(poem),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseModel update(@RequestBody Poem poem) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.update(poem),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseModel delete(@PathVariable Long id) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.delete(id),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    // Kategoriye göre şiirleri getiren metod
    @RequestMapping(value = "/getByCategory/{categoryId}", method = RequestMethod.GET)
    public ResponseModel getByCategory(@PathVariable Long categoryId) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.getAllByCategoryId(categoryId),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    // idye göre şiirleri getiren metod
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public ResponseModel getById(@PathVariable Long id) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.getById(id),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/getByIdAndUserId/{id}/{userId}", method = RequestMethod.GET)
    public ResponseModel getByIdAndUserId(@PathVariable Long id, @PathVariable Long userId) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.getByIdAndUserId(id,userId),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/getAllByUserId/{userId}", method = RequestMethod.GET)
    public ResponseModel getAllByUserId(@PathVariable Long userId) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.getAllByUserId(userId),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/getAllByUserIdAndCount/{userId}", method = RequestMethod.GET)
    public ResponseModel getAllByUserIdAndCount(@PathVariable Long userId) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.getAllByUserIdAndCount(userId),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/getPoemsBySearchText/{text}", method = RequestMethod.GET)
    public ResponseModel getPoemsBySearchText(@PathVariable String text) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.getPoemsBySearchText(text),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/getPoemsBySearchTextAndCategoryId/{text}/{categoryId}", method = RequestMethod.GET)
    public ResponseModel getPoemsBySearchTextAndCategoryId(@PathVariable String text,@PathVariable Long categoryId) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.getPoemsBySearchTextAndCategoryId(text,categoryId),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }
}
