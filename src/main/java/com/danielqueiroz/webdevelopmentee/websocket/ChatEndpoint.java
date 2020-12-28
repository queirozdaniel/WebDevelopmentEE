package com.danielqueiroz.webdevelopmentee.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@ServerEndpoint(value = "/chat")
public class ChatEndpoint {

    public static Queue<Session> sessions = new ConcurrentLinkedQueue<>();

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("Conexão aberta em CHAT");
        sessions.add(session);


    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) throws IOException {
        System.out.println("Conexão fechada em CHAT");
        sessions.remove(session);

        String name = (String) session.getUserProperties().get("name");
        broadcast(name + " saiu do chat!");
    }

    @OnError
    public void onError(Session session, Throwable thr) {
        System.out.println("Erro em conexão de CHAT");
        thr.printStackTrace();
    }

    @OnMessage
    public void messageReceiver(Session session, String message) throws IOException {
        System.out.println("Conexão CHAT messageReceiver: "+ message);

        if (message.startsWith("!C!")){
            String name = message.substring(3);
            session.getUserProperties().put("name", name);
            broadcast(name + " entrou no chat!");
        } else {
            LocalTime now = LocalTime.now();
            String name = (String) session.getUserProperties().get("name");
            String formattedMessage = String.format("[%tH:%tM:%tS] %s -> %s", now,now, now,name, message);
            broadcast(formattedMessage);
        }

    }

    private void broadcast(String message) throws IOException {
        for (Session session : sessions) {
            session.getBasicRemote().sendText(message);
        }
    }



}
