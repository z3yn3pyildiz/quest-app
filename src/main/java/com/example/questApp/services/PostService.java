package com.example.questApp.services;

import com.example.questApp.entities.Post;
import com.example.questApp.entities.User;
import com.example.questApp.repos.PostRepository;
import com.example.questApp.requests.PostCreateRequest;
import com.example.questApp.requests.PostUpdateRequest;
import com.example.questApp.services.interfaces.IPostService;
import com.example.questApp.services.interfaces.IUserServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService{

    private UserService _userService;
    private PostRepository _postRepository;

    public PostService(UserService userService, PostRepository postRepository) {
        this._postRepository=postRepository;
        this._userService = userService;
    }

    @Override
    public List<Post> GetAllPosts(Optional<Long> userId) {
        if(userId.isPresent())
            return _postRepository.findByUserId(userId.get());
        return _postRepository.findAll();
    }

    @Override
    public Post GetOnePost(Long postId) {
        return _postRepository.findById(postId).orElse(null);
    }

    @Override
    public Post CreateOnePost(PostCreateRequest newPost) {
        User user= _userService.FindUserById(newPost.getUserId());
        if(user ==  null)
            return null;
        Post toSave=new Post();
        toSave.setId(newPost.getId());
        toSave.setText(newPost.getText());
        toSave.setTitle(newPost.getTitle());
        toSave.setUser(user);
        return _postRepository.save(toSave);
    }

    @Override
    public Post UpdateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post=_postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate=post.get();
            toUpdate.setTitle(updatePost.getTitle());
            toUpdate.setText(updatePost.getText());
            return _postRepository.save(toUpdate);
        }
        return null;
    }

    @Override
    public void DeletePostById(Long postId) {
        _postRepository.deleteById(postId);
    }
}
