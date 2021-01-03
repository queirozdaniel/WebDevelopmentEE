package com.danielqueiroz.webdevelopmentee.rest;

import com.danielqueiroz.webdevelopmentee.model.Song;
import com.danielqueiroz.webdevelopmentee.model.Songs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/music")
public class MusicService {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String loadNames(){
        StringBuilder sb = new StringBuilder("<html><body><h1>Nomes das Músicas</h1><ul>");

        Songs.list().stream()
                .forEach(song -> sb.append("<li>").append(song.getName()).append("</li>"));

        sb.append("</ul></body></html>");
        return sb.toString();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> loadSongsAsJson(){
        return Songs.list();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Song findSongById(@PathParam("id") int id){
        return Songs.findById(id);
    }

    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public Song findSongByIdQuery(@QueryParam("id") int id){
        return Songs.findById(id);
    }

}
