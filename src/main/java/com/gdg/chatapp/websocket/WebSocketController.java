package com.gdg.chatapp.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.gdg.chatapp.models.ChatModel;

/**
 * 
 * @author azar
 *
 */

@Controller
public class WebSocketController {

	private final SimpMessagingTemplate template;

	@Autowired
	WebSocketController(SimpMessagingTemplate template) {
		this.template = template;
	}

	@MessageMapping("/send/message")
	public void onReceivedMessage(String message) {
		System.out.println("Message " + message);
		this.template.convertAndSend("/chat", new SimpleDateFormat("HH:mm:ss").format(new Date()) + "-" + message);
	}

	/**
	 * @author azar
	 * @param message It is {@link ChatModel} model that receives message to be sent
	 * 
	 */
	@MessageMapping("msg/send/{username}")
	public void sendMessage(@RequestBody ChatModel messageModel) {
		this.template.convertAndSend("/chat/" + messageModel.getToPhoneNo(),messageModel.getMessage());
	}

}
