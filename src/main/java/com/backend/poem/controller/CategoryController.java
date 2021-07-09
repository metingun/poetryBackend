package com.backend.poem.controller;

import com.backend.poem.model.Category;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.service.CategoryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/category", produces = "application/json")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseModel save(@RequestBody Category category) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(categoryService.save(category),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    // Tüm kategorileri getiren metod
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseModel getAll() {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(categoryService.getAllCategories(),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }
}
