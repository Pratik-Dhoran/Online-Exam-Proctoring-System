package com.exam.online_exam_system.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserRegisterRequest {

    @NotBlank
    private String name ;

    @NotBlank
    @Email
    private String email ;

    @NotBlank
    private String password ;

    @NotBlank
    private String role ;
}
