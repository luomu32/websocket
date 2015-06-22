package io.ray.websocket.controller.websocket;

import java.io.IOException;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

public class TextMessageHandler extends BinaryWebSocketHandler {

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) {

		System.out.println(message.getPayload());

		try {
			session.sendMessage(new TextMessage("hi," + message.getPayload()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
