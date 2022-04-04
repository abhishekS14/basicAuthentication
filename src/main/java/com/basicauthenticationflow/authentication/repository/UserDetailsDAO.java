package com.basicauthenticationflow.authentication.repository;

import com.basicauthenticationflow.authentication.model.User;

public interface UserDetailsDAO {

    boolean persistUserDetails(User user);
    boolean validateUserDetails(User user);

}
