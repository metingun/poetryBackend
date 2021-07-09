package com.backend.poem.controller;

import com.backend.poem.model.CommentsDTO;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.service.CommentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/comment", produces = "application/json")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Yorum yapma metodu
    @RequestMapping(value = "/doComment", method = RequestMethod.POST)
    public ResponseModel doComment(@RequestBody CommentsDTO commentsDTO) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(commentService.doComment(commentsDTO),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }

    // Tüm kategorileri getiren metod
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseModel getAll() {
        try {
            return ResponseModel
                    .createSuccessResponseWithData("",false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }
}
