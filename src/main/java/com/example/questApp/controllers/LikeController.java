package com.example.questApp.controllers;

import com.example.questApp.services.LikeService;
import com.example.questApp.services.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {
    private LikeService _likeService;

    public LikeController(LikeService likeService) {
        this._likeService = likeService;
    }
}
