package com.StackOverflow.AuthService.controller;

import com.StackOverflow.AuthService.dto.LoginRequest;
import com.StackOverflow.AuthService.dto.SignupRequest;
import com.StackOverflow.AuthService.service.AuthServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthServiceI authServiceI;

    public AuthController(AuthServiceI authServiceI) {
        this.authServiceI = authServiceI;
    }

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return new ResponseEntity<>("AuthService is up and running", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        String token = authServiceI.login(req);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> singup(@RequestBody SignupRequest req) {
        authServiceI.signup(req);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
