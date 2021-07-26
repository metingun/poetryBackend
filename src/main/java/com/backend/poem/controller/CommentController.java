package com.backend.poem.controller;

import com.backend.poem.iface.ICommentService;
import com.backend.poem.model.CommentsDTO;
import com.backend.poem.model.ResponseModel;
import com.backend.poem.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/comment", produces = "application/json")
public class CommentController {

    private final ICommentService commentService;

    public CommentController(ICommentService commentService) {
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
    @RequestMapping(value = "/getAll/{poemId}", method = RequestMethod.GET)
    public ResponseModel getAll(@PathVariable Long poemId) {
        try {
            return ResponseModel
                    .createSuccessResponseWithData(commentService.getCommentsByPoemId(poemId),false);
        } catch (Exception e) {
            return ResponseModel.createErrorResponseWithErrorMessage(e);
        }
    }
}
