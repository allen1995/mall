package com.allen.springbootwebsocket.controller;

import com.allen.springbootwebsocket.entity.Chat;
import com.allen.springbootwebsocket.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @Auther: 20190598
 * @Date: 2020/9/7 10:18
 * @Description:
 */
@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) throws Exception {
        return message;
    }

    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat ){
        String from = principal.getName();
        chat.setFrom(from);

        template.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
    }
}
