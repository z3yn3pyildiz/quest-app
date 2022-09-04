package com.example.questApp.services;

import com.example.questApp.entities.User;
import com.example.questApp.repos.UserRepository;
import com.example.questApp.services.interfaces.IUserServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserServices {
    UserRepository _userRepository;

    public UserService(UserRepository userRepository) {
        this._userRepository = userRepository;
    }

    @Override
    public List<User> GetAllUsers() {
        return _userRepository.findAll();
    }

    @Override
    public User FindUserById(Long id) {
        return _userRepository.findById(id).orElse(null);
    }

    @Override
    public void DeleteUserById(Long id) {
        _userRepository.deleteById(id);
    }

    @Override
    public User SaveUser(User user) {
        return _userRepository.save(user);
    }

    @Override
    public User UpdateUser(Long userId, User updateUser) {
        Optional<User> user= _userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(updateUser.getUserName());
            foundUser.setPassWord((updateUser.getPassWord()));
            _userRepository.save(foundUser);
            return foundUser;
        }else {
            return null;
        }
    }
}
