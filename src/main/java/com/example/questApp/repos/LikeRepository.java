package com.example.questApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questApp.entities.Like;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findByPostId(Long postId);

    List<Like> findByUserId(Long userId);

    List<Like> findByUserIdAndPostId(Long userId, Long postId);
}
