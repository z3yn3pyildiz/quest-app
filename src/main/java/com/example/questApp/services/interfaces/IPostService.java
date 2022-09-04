package com.example.questApp.services.interfaces;

import com.example.questApp.entities.Post;
import com.example.questApp.requests.PostCreateRequest;
import com.example.questApp.requests.PostUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> GetAllPosts (Optional<Long> userId);
    Post GetOnePost (Long postId);
    Post CreateOnePost (PostCreateRequest newPost);

    Post UpdateOnePostById(Long postId, PostUpdateRequest updatePost);
    void DeletePostById(Long postId);
}
