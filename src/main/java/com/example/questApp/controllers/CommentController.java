package com.example.questApp.controllers;

import com.example.questApp.services.CommentService;
import com.example.questApp.services.LikeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService _commentService;

    public CommentController(CommentService commentService) {
        this._commentService = commentService;
    }
}
