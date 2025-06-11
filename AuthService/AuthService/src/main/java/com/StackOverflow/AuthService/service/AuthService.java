package com.StackOverflow.AuthService.service;

import com.StackOverflow.AuthService.dto.LoginRequest;
import com.StackOverflow.AuthService.dto.SignupRequest;
import com.StackOverflow.AuthService.entity.MyUser;
import com.StackOverflow.AuthService.exception.BadRequestException;
import com.StackOverflow.AuthService.repository.MyUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService implements AuthServiceI {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    private final MyUserRepository myUserRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    public AuthService(MyUserRepository myUserRepository, ModelMapper modelMapper, JwtService jwtService) {
        this.myUserRepository = myUserRepository;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
    }

    @Override
    public String login(LoginRequest req) {
        MyUser user = myUserRepository.findByEmail(req.getEmail()).orElseThrow(() -> new BadRequestException("User with this email or password doesn't exists"));
        log.info("user {}, {}", BCrypt.hash(req.getPassword()), user.getPassword());

        boolean isPasswordMatched = BCrypt.match(+req.getPassword(), user.getPassword());
        log.info("isPass {}", isPasswordMatched);
        if(!isPasswordMatched) throw new BadRequestException("User with this email or password doesn't exists");

        return jwtService.generateToken(user);
    }

    @Override
    public void signup(SignupRequest req) {
        try{
            log.info("Req {}", req.toString());
            MyUser user = modelMapper.map(req, MyUser.class);
            user.setPassword(BCrypt.hash(user.getPassword()));
            log.info("user {}", user.toString());
            myUserRepository.save(user);
        } catch (Exception e) {
            throw new BadRequestException(e.getLocalizedMessage());
        }
    }
}
