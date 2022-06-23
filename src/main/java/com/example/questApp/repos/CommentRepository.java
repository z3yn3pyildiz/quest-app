package com.example.questApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questApp.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
