package com.exam.online_exam_system.user.service;

import com.exam.online_exam_system.common.dto.LoginRequest;
import com.exam.online_exam_system.common.dto.LoginResponse;
import com.exam.online_exam_system.common.dto.UserRegisterRequest;
import com.exam.online_exam_system.user.entity.User;

public interface UserService {

    User registerUser(UserRegisterRequest request);

    LoginResponse login(LoginRequest request);

}
