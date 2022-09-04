package com.example.questApp.services;

import com.example.questApp.repos.LikeRepository;
import com.example.questApp.services.interfaces.ILileService;
import org.springframework.stereotype.Service;

@Service
public class LikeService implements ILileService {
    private LikeRepository _likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this._likeRepository =likeRepository;
    }
}
