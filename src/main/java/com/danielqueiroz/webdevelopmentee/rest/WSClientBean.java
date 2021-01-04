package com.danielqueiroz.webdevelopmentee.rest;

import com.danielqueiroz.webdevelopmentee.model.Song;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Singleton
public class WSClientBean {

    private static final String URI_BASE = "http://localhost:8080/WebDevelopmentEE/services/music";

    private Client wsClient;

    @PostConstruct
    public void setup(){
        wsClient = ClientBuilder.newClient();

    }

    @PreDestroy
    public void destroy(){
        if (wsClient != null) wsClient.close();
    }

    public List<Song> list(){
        return wsClient.target(URI_BASE)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Song>>(){});

    }

    public Song find(int songId){
        return wsClient.target(URI_BASE)
                .path(String.valueOf(songId))
                .request()
                .get(Song.class);
    }

    public Response delete(int songId){
        return wsClient.target(URI_BASE)
                .path(String.valueOf(songId))
                .request()
                .delete();
    }

    public Response create(Song song){
        return wsClient.target(URI_BASE)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(song));
    }

    public Response update(Song song){
        return wsClient.target(URI_BASE)
                .path(String.valueOf(song.getId()))
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(song));
    }
}
