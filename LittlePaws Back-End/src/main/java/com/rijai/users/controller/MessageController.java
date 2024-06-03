package com.rijai.users.controller;

import com.rijai.users.repository.MessageRepository;
import com.rijai.users.services.MessageService;
import org.springframework.web.bind.annotation.*;
import com.rijai.users.model.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class MessageController {

    private MessageService messageService;
    private MessageRepository messageRepository;

    public MessageController(MessageService messageService,MessageRepository messageRepository)
    {
        this.messageService = messageService;
        this.messageRepository = messageRepository;
    }

    @RequestMapping(value="/api/add-message", method= RequestMethod.POST)
    public Message addMessage(@RequestBody Message message)
    {
        return messageService.addMessage(message);
    }

}
