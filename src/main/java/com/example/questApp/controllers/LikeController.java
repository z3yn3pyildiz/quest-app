package com.example.questApp.controllers;

import com.example.questApp.entities.Comment;
import com.example.questApp.entities.Like;
import com.example.questApp.requests.CommentCreateRequest;
import com.example.questApp.requests.CommentUpdateRequest;
import com.example.questApp.requests.LikeCreateRequest;
import com.example.questApp.services.LikeService;
import com.example.questApp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/like")
public class LikeController {
    private LikeService _likeService;

    public LikeController(LikeService likeService) {
        this._likeService = likeService;
    }

    @GetMapping
    public List<Like> getAlLİkes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return  _likeService.GetAllLikes(userId,postId);
    }
    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId){
        return  _likeService.GetOneLike(likeId);
    }

    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest createRequest){
        return _likeService.CreateOneLike(createRequest);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneComment(@PathVariable Long likeId){
        _likeService.DeleteOneLike(likeId);
    }
}
