package com.application.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.application.model.ChatMessage;
import com.application.model.MessageType;

import java.util.logging.Logger;

@Component
public class MessageEventListener {
	@Autowired
	private SimpMessageSendingOperations operations;
	
	private static final Logger logger = Logger.getLogger(MessageEventListener.class.getName());


	@EventListener
	private void handleDisconnectListener(SessionDisconnectEvent event) {

		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage()); // Correct the typo here
		String username = (String) headerAccessor.getSessionAttributes().get("username");

		if (username != null) {
			logger.info("User Disconnected: " + username);
			ChatMessage chatMessage = ChatMessage.builder().type(MessageType.LEAVE).sender(username).build();
			operations.convertAndSend("/topic/public", chatMessage);
		}
	}
}
