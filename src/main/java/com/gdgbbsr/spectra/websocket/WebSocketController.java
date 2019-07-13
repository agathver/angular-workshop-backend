package com.gdgbbsr.spectra.websocket;

import com.gdgbbsr.spectra.dto.Message;
import com.gdgbbsr.spectra.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.Collections;

/**
 * @author azar
 */

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/channels/{id}/send_message")
    @SendTo("/topic/public")
    public String onReceivedMessage(@DestinationVariable String id, @Payload Message message) {
        System.out.printf("Channel %s, Message %s\n", id, message);
//        this.template.convertAndSend("/topic/channels/" + id, message);
        this.template.convertAndSend("/topic/public", "Hello World!");

        return "Wohaahhha!";
    }

    @MessageMapping("/channels/{id}/join")
    public void onUserJoin(@DestinationVariable String id, @Payload User user) {
        System.out.println("User joined: " + user);
        Message message = new Message();
        message.setType(Message.MessageType.JOIN);
        message.setUsername(user.getUsername());
//        this.template.convertAndSend("/topic/channels/" + id, message);
    }
}
