package com.messenger.api;

import com.messenger.dto.WsMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class MessengerController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
//    @SendTo("/topic")
    public void sendMassage(@Payload WsMessageDto wsMassage){
        System.out.println(wsMassage);
        messagingTemplate.convertAndSend("/topic",wsMassage);
    }
}
