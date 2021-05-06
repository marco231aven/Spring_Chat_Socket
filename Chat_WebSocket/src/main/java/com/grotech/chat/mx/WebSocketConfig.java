package com.grotech.chat.mx;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//configuracion de la url para conectarnos desde angular al servidor web socket
		registry.addEndpoint("/chat-websocket")
		//cores para angular
		.setAllowedOrigins("http://localhost:4200")
		//stomp utilizara withSockJS
		.withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//prefijo para nombres de los eventos
		registry.enableSimpleBroker("/chat/");
		//prefijo para el destino donde se publicara
		registry.setApplicationDestinationPrefixes("/app/");
		
	
	}
}
