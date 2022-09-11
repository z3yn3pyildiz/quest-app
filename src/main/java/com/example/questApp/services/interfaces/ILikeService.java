package com.example.questApp.services.interfaces;

import com.example.questApp.entities.Like;
import com.example.questApp.requests.LikeCreateRequest;
import com.example.questApp.responces.LikeResponse;

import java.util.List;
import java.util.Optional;

public interface ILikeService {
    List<LikeResponse> GetAllLikes (Optional<Long> userId, Optional<Long> postId);
    Like GetOneLike(Long likeId);
    Like CreateOneLike(LikeCreateRequest createRequest);
    void DeleteOneLike(Long likeId);
}
