package com.example.questApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questApp.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
