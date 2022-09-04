package com.example.questApp.controllers;

import com.example.questApp.entities.Post;
import com.example.questApp.requests.PostCreateRequest;
import com.example.questApp.requests.PostUpdateRequest;
import com.example.questApp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService _postService;

    public PostController(PostService postService) {
        this._postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts (@RequestParam Optional<Long> userId){
        return _postService.GetAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return _postService.GetOnePost(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPost){
       return  _postService.CreateOnePost(newPost);
    }

    @PutMapping("/{postId}")
    public  Post updateOnePost (@PathVariable Long postId,@RequestBody PostUpdateRequest updatePost){
        return  _postService.UpdateOnePostById(postId,updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deletePostById(@PathVariable Long postId){
        _postService.DeletePostById(postId);
    }


}
