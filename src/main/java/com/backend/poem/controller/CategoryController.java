package com.backend.poem.controller;

import com.backend.poem.iface.ICategoryService;
import com.backend.poem.model.Category;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/category", produces = "application/json")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseModel add(@RequestBody Category category) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(categoryService.add(category),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseModel update(@RequestBody Category category) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(categoryService.update(category),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseModel delete(@PathVariable Long id) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(categoryService.delete(id),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    // Tüm kategorileri getiren metod
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseModel getAll() {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(categoryService.getAll(),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/getAllByUserId/{userId}", method = RequestMethod.GET)
    public ResponseModel getAllByUserId(@PathVariable Long userId) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(categoryService.getAllByUserId(userId),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    @RequestMapping(value = "/getById/{categoryId}", method = RequestMethod.GET)
    public ResponseModel getById(@PathVariable Long categoryId) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(categoryService.getById(categoryId),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }
}
