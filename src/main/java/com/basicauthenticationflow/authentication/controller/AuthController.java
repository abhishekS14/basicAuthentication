package com.basicauthenticationflow.authentication.controller;

import com.basicauthenticationflow.authentication.model.User;
import com.basicauthenticationflow.authentication.repository.UserDetailsDAO;
import com.basicauthenticationflow.authentication.service.LoginService;
import com.basicauthenticationflow.authentication.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.basicauthenticationflow")
public class AuthController {

    @Autowired
    private RegisterService registerService;
    @Autowired
    private LoginService loginService;

    @Autowired
    private UserDetailsDAO userDetailsDAO;

    @GetMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (registerService.registerUser(user)) {
            return new ResponseEntity<>("User registered successfully" , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Username already exists" , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        if (loginService.loginUser(user)) {
            return new ResponseEntity<>("User logged in successfully" , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Invalid usernmame/password" , HttpStatus.BAD_REQUEST);
        }
    }

}
