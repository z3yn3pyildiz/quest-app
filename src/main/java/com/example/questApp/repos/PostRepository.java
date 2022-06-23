package com.example.questApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questApp.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
