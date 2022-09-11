package com.example.questApp.services;

import com.example.questApp.entities.Like;
import com.example.questApp.entities.Post;
import com.example.questApp.entities.User;
import com.example.questApp.repos.LikeRepository;
import com.example.questApp.requests.LikeCreateRequest;
import com.example.questApp.responces.LikeResponse;
import com.example.questApp.services.interfaces.ILikeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<LikeResponse> GetAllLikes(Optional<Long> userId, Optional<Long> postId) {
        List<Like> likes;
        if(userId.isPresent() && postId.isPresent() )
            likes = _likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
        else if(userId.isPresent())
            likes = _likeRepository.findByUserId(userId.get());
        else if(postId.isPresent())
            likes = _likeRepository.findByPostId(postId.get());
        else
            likes = _likeRepository.findAll();
        return  likes.stream().map(like -> new LikeResponse(like)).collect((Collectors.toList()));
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
