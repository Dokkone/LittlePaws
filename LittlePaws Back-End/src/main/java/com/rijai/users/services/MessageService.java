package com.rijai.users.services;

import com.rijai.users.model.Message;
import com.rijai.users.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService{

    @Autowired
    private MessageRepository messageRepository;

    public Message addMessage(Message message)
    {
        return messageRepository.save(message);
    }

}
