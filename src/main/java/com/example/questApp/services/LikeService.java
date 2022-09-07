package com.example.questApp.services;

import com.example.questApp.entities.Like;
import com.example.questApp.entities.Post;
import com.example.questApp.entities.User;
import com.example.questApp.repos.LikeRepository;
import com.example.questApp.requests.LikeCreateRequest;
import com.example.questApp.services.interfaces.ILikeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LikeService implements ILikeService {
    private LikeRepository _likeRepository;
    private UserService _userService;
    private PostService _postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this._postService = postService;
        this._userService = userService;
        this._likeRepository =likeRepository;
    }

    @Override
    public List<Like> GetAllLikes(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent() )
            return _likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
        else if(userId.isPresent())
            return _likeRepository.findByUserId(userId.get());
        else if(postId.isPresent())
            return _likeRepository.findByPostId(postId.get());
        return _likeRepository.findAll();
    }

    @Override
    public Like GetOneLike(Long likeId) {
        return _likeRepository.findById(likeId).orElse(null);
    }

    @Override
    public Like CreateOneLike(LikeCreateRequest createRequest) {
        User user = _userService.FindUserById(createRequest.getUserId());
        Post post = _postService.GetOnePost(createRequest.getPostId());
        if(user != null && post != null){
            Like likeToSave =new Like();
            likeToSave.setId(createRequest.getId());
            likeToSave.setPost(post);
            likeToSave.setUser(user);
            return _likeRepository.save(likeToSave);
        }
        else
            return null;
    }

    @Override
    public void DeleteOneLike(Long likeId) {
        _likeRepository.deleteById(likeId);
    }
}
