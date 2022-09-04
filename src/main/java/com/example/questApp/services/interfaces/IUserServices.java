package com.example.questApp.services.interfaces;

import com.example.questApp.entities.User;

import java.util.List;

public interface IUserServices {
    List<User> GetAllUsers ();
    User FindUserById (Long id);
    void DeleteUserById (Long id);
    User SaveUser (User user);
    User UpdateUser(Long userId, User updateUser);
}
