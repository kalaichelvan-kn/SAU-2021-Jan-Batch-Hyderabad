package com.accolite.restapi_au.controllers;

import com.accolite.restapi_au.entity.PrivateMessage;
import com.accolite.restapi_au.entity.User;
import com.accolite.restapi_au.services.PrivateMessageService;
import com.accolite.restapi_au.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/message")
public class PrivateMessageController {

    @Autowired
    UserService userService;

    @Autowired
    PrivateMessageService privateMessageService;

    @PostMapping("/add")
    public ResponseEntity<Object> addMessage(@RequestParam("uid") int userId, @RequestBody PrivateMessage privateMessage){
        Optional<User> user = userService.getUser(userId);
        if (Objects.nonNull(user)) {
            privateMessage.setUserId(user.get().getUserId());
            privateMessage.setCreatedTime(new Timestamp(System.currentTimeMillis()));
            privateMessage = privateMessageService.addMessage(privateMessage);
            return ResponseEntity.ok(privateMessage);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get")
    public  ResponseEntity<Object> getMessages(@RequestParam("id") int userId){
        Optional<User> user = userService.getUser(userId);
        if (Objects.nonNull(user)) {
            List<PrivateMessage> privateMessageList = privateMessageService.getMessages(userId);
            return ResponseEntity.ok(privateMessageList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteMessage(@RequestParam("id") int messageId){
        Map<String, String> result = privateMessageService.deleteMessage(messageId);
        return ResponseEntity.ok(result);
    }
}
