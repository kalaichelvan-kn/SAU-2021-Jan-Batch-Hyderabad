package com.accolite.restapi_au.services;

import com.accolite.restapi_au.entity.PrivateMessage;

import java.util.List;
import java.util.Map;

public interface PrivateMessageService {
    PrivateMessage addMessage(PrivateMessage privateMessage);
    List<PrivateMessage> getMessages(int UserId);
    Map<String, String> deleteMessage(int messageId);
}
