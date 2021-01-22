package com.accolite.restapi_au.services;

import com.accolite.restapi_au.entity.User;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    Optional<User> getUser(int userId);
    Map<String, Object> updateUser(User user);
}
