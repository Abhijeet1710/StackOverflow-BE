package com.StackOverflow.AuthService.service;

import com.StackOverflow.AuthService.dto.LoginRequest;
import com.StackOverflow.AuthService.dto.SignupRequest;

public interface AuthServiceI {

    public String login(LoginRequest req);
    public void signup(SignupRequest req);
}
