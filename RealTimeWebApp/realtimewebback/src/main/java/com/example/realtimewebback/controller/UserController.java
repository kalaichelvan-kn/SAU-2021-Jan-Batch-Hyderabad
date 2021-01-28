package com.example.realtimewebback.controller;

import com.example.realtimewebback.dtos.UserDetails;
import lombok.var;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/userDetails")
    public List<UserDetails> getUserDetails(){
        final var userDetails = new LinkedList<UserDetails>();
        userDetails.add(new UserDetails("jack"));
        userDetails.add(new UserDetails("hamen"));
        userDetails.add(new UserDetails("lini"));
        userDetails.add(new UserDetails("ani"));
        return userDetails;
    }
}