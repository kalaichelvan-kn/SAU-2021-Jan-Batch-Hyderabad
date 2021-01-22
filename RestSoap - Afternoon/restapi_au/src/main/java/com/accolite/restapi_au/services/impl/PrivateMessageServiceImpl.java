package com.accolite.restapi_au.services.impl;

import com.accolite.restapi_au.entity.PrivateMessage;
import com.accolite.restapi_au.repository.PrivateMessageRepository;
import com.accolite.restapi_au.services.PrivateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PrivateMessageServiceImpl implements PrivateMessageService {

    @Autowired
    PrivateMessageRepository privateMessageRepository;

    @Override
    public PrivateMessage addMessage(PrivateMessage privateMessage){
        privateMessageRepository.save(privateMessage);
        return privateMessage;
    }
    @Override
    public List<PrivateMessage> getMessages(int userId){
        List<PrivateMessage> privateMessageList = privateMessageRepository.findByUserId(userId);
        return privateMessageList;
    }

    @Override
    public Map<String, String> deleteMessage(int messageId){
        Map<String, String> obj = new HashMap<>();
        if(privateMessageRepository.existsById(messageId)){
            privateMessageRepository.deleteById(messageId);
            obj.put(String.valueOf(messageId), "deleted");
        }else{
            obj.put(String.valueOf(messageId), "not found");
        }
        return obj;
    }
}
