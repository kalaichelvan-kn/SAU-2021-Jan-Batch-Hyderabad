package com.accolite.restapi_au.services.impl;

import com.accolite.restapi_au.entity.User;
import com.accolite.restapi_au.repository.UserRepository;
import com.accolite.restapi_au.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        user.setPassword(getEncryptedPassword(user.getPassword()));
        User resultUser = userRepository.save(user);
        return resultUser;
    }

    @Override
    public Optional<User> getUser(int userId){
        Optional<User> resultUser = userRepository.findById(userId);
        if(Objects.nonNull(resultUser))
            return resultUser;
        else
            return null;
    }

    @Override
    public Map<String, Object> updateUser(User user){
        Map<String, Object> obj = new HashMap<>();
        if(userRepository.existsById(user.getUserId())){
            user = userRepository.save(user);
            obj.put("status","updated");
        }else{
            obj.put("status","notUpdated");
        }
        obj.put("user",user);
        return obj;
    }

    public String getEncryptedPassword(String pwd){
        return new BCryptPasswordEncoder(16).encode(pwd);
    }
}
