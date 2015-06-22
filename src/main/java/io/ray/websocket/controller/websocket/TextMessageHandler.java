package io.ray.websocket.controller.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

public class TextMessageHandler extends BinaryWebSocketHandler {

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) {

		System.out.println(message.getPayload());
	}

}
