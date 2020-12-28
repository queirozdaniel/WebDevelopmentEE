package com.danielqueiroz.webdevelopmentee.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

// Server Side
@ServerEndpoint("/server")
public class EchoEndpoint {

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("Conexão aberta");
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Conexão fechada");

    }

    @OnError
    public void onError(Session session, Throwable thr) {
        System.out.println("Erro em conexão");
        thr.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        System.out.println("Mensagem recebida: " + message);

        session.getBasicRemote().sendText(message);

    }

}
