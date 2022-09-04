package com.example.questApp.services.interfaces;

import com.example.questApp.entities.Comment;
import com.example.questApp.requests.CommentCreateRequest;
import com.example.questApp.requests.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    List<Comment> GetAllComments (Optional<Long> userId,Optional<Long> postId);
    Comment GetOneComment(Long commentId);
    Comment UpdateOneComment(Long commentId, CommentUpdateRequest updateRequest);

    Comment CreateOneComment(CommentCreateRequest createRequest);

    void DeleteOneComment(Long commentId);
}
