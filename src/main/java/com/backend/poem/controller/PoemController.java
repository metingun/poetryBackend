package com.backend.poem.controller;

import com.backend.poem.model.Poem;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.service.PoemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/poem", produces = "application/json")
public class PoemController {

    private final PoemService poemService;

    public PoemController(PoemService poemService) {
        this.poemService = poemService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseModel save(@RequestBody Poem poem) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.save(poem),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    // Kategoriye göre şiirleri getiren metod
    @RequestMapping(value = "/getByCategory/{categoryId}", method = RequestMethod.GET)
    public ResponseModel getByCategory(@PathVariable Long categoryId) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(poemService.getPoemsByCategoryId(categoryId),false);
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
}
