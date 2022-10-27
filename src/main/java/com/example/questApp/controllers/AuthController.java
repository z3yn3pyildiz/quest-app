package com.example.questApp.controllers;

import com.example.questApp.entities.User;
import com.example.questApp.requests.UserRequest;
import com.example.questApp.security.JwtTokenProvider;
import com.example.questApp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public  String Login(@RequestBody UserRequest loginRequest){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtTokenProvider.generateJwtToken(authentication);
        return "Bearer "+jwtToken;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody UserRequest registerRequest){
        if(userService.GetUserByName(registerRequest.getUserName()) != null){
            return new ResponseEntity<>("Username already in use.", HttpStatus.BAD_REQUEST);
        }else{
            User user = new User();
            user.setUserName(registerRequest.getUserName());
            user.setPassWord(passwordEncoder.encode(registerRequest.getPassword()));
            userService.SaveUser(user);
            return  new ResponseEntity<>("User successfully registered", HttpStatus.CREATED);
        }
    }

}
