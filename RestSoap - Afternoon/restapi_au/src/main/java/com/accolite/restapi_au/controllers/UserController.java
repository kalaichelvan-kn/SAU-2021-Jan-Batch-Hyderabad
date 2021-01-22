package com.accolite.restapi_au.controllers;

import com.accolite.restapi_au.entity.User;
import com.accolite.restapi_au.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public User signUp(@RequestBody Map<String, String> obj){
        System.out.println(obj);
        User user = new User(obj.get("email"),obj.get("password"));
        user = userService.addUser(user);
        return user;
    }

    @GetMapping("/find")
    public Object getUser(@RequestParam("id") int userId){
        System.out.println("kn userid get user: "+userId);
        Optional<User> user = userService.getUser(userId);
        if(Objects.nonNull(user)){
            return user;
        }else{
            return "Not found";
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Object> deleteUser(@RequestBody User user){
        Map<String,Object> result = userService.updateUser(user);
        return ResponseEntity.ok(result);
    }
}
