package com.example.questApp.services;

import com.example.questApp.entities.Comment;
import com.example.questApp.entities.Post;
import com.example.questApp.entities.User;
import com.example.questApp.repos.CommentRepository;
import com.example.questApp.requests.CommentCreateRequest;
import com.example.questApp.requests.CommentUpdateRequest;
import com.example.questApp.services.interfaces.ICommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    private CommentRepository _commentRepository;
    private UserService _userService;
    private PostService _postService;
    public CommentService(CommentRepository commentRepository,UserService userService, PostService postService) {
        this._commentRepository = commentRepository;
        this._userService = userService;
        this._postService = postService;
    }

    @Override
    public List<Comment> GetAllComments(Optional<Long> userId,Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent() )
            return _commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
        else if(userId.isPresent())
            return _commentRepository.findByUserId(userId.get());
        else if(postId.isPresent())
            return _commentRepository.findByPostId(postId.get());
        return _commentRepository.findAll();
    }

    @Override
    public Comment GetOneComment(Long commentId) {
        return _commentRepository.findById(commentId).orElse(null );
    }

    @Override
    public Comment CreateOneComment(CommentCreateRequest createRequest) {
        User user = _userService.FindUserById(createRequest.getUserId());
        Post post = _postService.GetOnePost(createRequest.getPostId());
        if(user != null && post != null){
            Comment commentToSave =new Comment();
            commentToSave.setId(createRequest.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(createRequest.getText());
            return _commentRepository.save(commentToSave);
        }
        else
            return null;
    }

    @Override
    public void DeleteOneComment(Long commentId) {
        _commentRepository.deleteById(commentId);
    }

    @Override
    public Comment UpdateOneComment(Long commentId, CommentUpdateRequest updateRequest) {
        Optional<Comment> comment = _commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment commentToUpdate=comment.get();
            commentToUpdate.setText(updateRequest.getText());
            _commentRepository.save(commentToUpdate);
        }
        return null;
    }
}
