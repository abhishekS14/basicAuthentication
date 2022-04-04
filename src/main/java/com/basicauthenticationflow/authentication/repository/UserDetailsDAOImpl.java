package com.basicauthenticationflow.authentication.repository;

import com.basicauthenticationflow.authentication.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO{

    private HashMap<String , String > userDetails = new HashMap<>();

    @Override
    public boolean persistUserDetails(User user) {
        if (!userDetails.containsKey(user.getUsername())) {
            userDetails.put(user.getUsername() , user.getPassword());
            return true;
        }

        else {
            return false;
        }
    }

    @Override
    public boolean validateUserDetails(User user) {
        if (userDetails.containsKey(user.getUsername())) {
            return userDetails.get(user.getUsername()).equals(user.getPassword());
        }

        return false;
    }
}
