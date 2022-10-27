package com.example.questApp.services;

import com.example.questApp.entities.User;
import com.example.questApp.repos.UserRepository;
import com.example.questApp.security.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository _userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this._userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = _userRepository.findByUserName(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id){
        return JwtUserDetails.create(_userRepository.findById(id).get());
    }
}
