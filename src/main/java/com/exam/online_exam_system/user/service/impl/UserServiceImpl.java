package com.exam.online_exam_system.user.service.impl;

import com.exam.online_exam_system.auth.jwt.JwtUtil;
import com.exam.online_exam_system.common.dto.LoginRequest;
import com.exam.online_exam_system.common.dto.LoginResponse;
import com.exam.online_exam_system.common.dto.UserRegisterRequest;
import com.exam.online_exam_system.common.exception.ApiException;
import com.exam.online_exam_system.user.entity.User;
import com.exam.online_exam_system.user.repository.UserRepository;
import com.exam.online_exam_system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository ;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(UserRegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ApiException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        return userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ApiException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ApiException("Invalid email or password");
        }

        String token = JwtUtil.generateToken(user.getEmail());

        return new LoginResponse(token);
    }


}
