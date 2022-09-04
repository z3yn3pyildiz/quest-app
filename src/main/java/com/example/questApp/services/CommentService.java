package com.example.questApp.services;

import com.example.questApp.repos.CommentRepository;
import com.example.questApp.services.interfaces.ICommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {
    private CommentRepository _commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this._commentRepository = commentRepository;
    }


}
