package com.basicauthenticationflow.authentication.service;

import com.basicauthenticationflow.authentication.model.User;
import com.basicauthenticationflow.authentication.repository.UserDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserDetailsDAO userDetailsDAO;

    public boolean registerUser(User user) {
        return userDetailsDAO.persistUserDetails(user);
    }
}
