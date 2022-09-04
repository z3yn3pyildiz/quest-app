package com.example.questApp.services.interfaces;

import com.example.questApp.entities.Comment;
import com.example.questApp.entities.Like;
import com.example.questApp.requests.CommentCreateRequest;
import com.example.questApp.requests.CommentUpdateRequest;
import com.example.questApp.requests.LikeCreateRequest;

import java.util.List;
import java.util.Optional;

public interface ILikeService {
    List<Like> GetAllLikes (Optional<Long> userId, Optional<Long> postId);
    Like GetOneLike(Long likeId);
    Like CreateOneLike(LikeCreateRequest createRequest);

    void DeleteOneLike(Long likeId);
}
