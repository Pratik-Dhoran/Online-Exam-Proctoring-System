package com.exam.online_exam_system.user.controller;

import com.exam.online_exam_system.common.dto.LoginRequest;
import com.exam.online_exam_system.common.dto.LoginResponse;
import com.exam.online_exam_system.common.dto.UserRegisterRequest;
import com.exam.online_exam_system.user.entity.User;
import com.exam.online_exam_system.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService ;

    @PostMapping("/register")
    public User register(@RequestBody @Valid UserRegisterRequest request)
    {
        return userService.registerUser(request) ;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request)
    {
        return userService.login(request) ;
    }

}
