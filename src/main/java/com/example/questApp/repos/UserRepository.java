package com.example.questApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questApp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
