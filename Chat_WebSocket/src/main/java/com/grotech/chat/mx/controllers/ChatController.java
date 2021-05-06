package com.grotech.chat.mx.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.grotech.chat.mx.models.documents.Mensaje;

@Controller
public class ChatController {
	private String[] colores = {"red","blue","green","magenta","purple","orange","silver","yellow","pink","black"};
	//Identifica que es un messageMaping
 @MessageMapping("/mensaje")
 //Con esta anotacion los usuarios escuchan y se deben subscribir
 @SendTo("/chat/mensaje")
  public Mensaje recibeMensaje(Mensaje mensaje) 
 {
	 mensaje.setFecha(new Date().getTime());
	 if(mensaje.getTipo().equals("NUEVO_USUARIO")) {
		 mensaje.setColor(colores[new Random().nextInt(colores.length)]);
		 mensaje.setTexto("nuevo usuario");
		 
	 }
	 
	 return mensaje;
 }
 
 
 @MessageMapping("/escribiendo")
 //Con esta anotacion los usuarios escuchan y se deben subscribir
 @SendTo("/chat/escribiendo")
  public String estaEscribiendo(String userName) {
	return userName.concat(" Está Escribiendo...");
	 
 }
  
}
