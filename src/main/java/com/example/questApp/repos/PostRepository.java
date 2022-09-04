package com.example.questApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questApp.entities.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserId(Long userId);
}
