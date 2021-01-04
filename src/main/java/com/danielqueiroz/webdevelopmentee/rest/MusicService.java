package com.danielqueiroz.webdevelopmentee.rest;

import com.danielqueiroz.webdevelopmentee.model.Song;
import com.danielqueiroz.webdevelopmentee.model.Songs;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/music")
public class MusicService {


    @GET
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
        Song song = Songs.findById(id);

        if (song == null) return null;

        return song;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createSong(@FormParam("name") String name, @FormParam("singer") String singer, @Context UriInfo uriInfo){
        int id = Songs.create(name, singer);

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(String.valueOf(id));

        URI uri = uriBuilder.build();

        return Response.created(uri).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Song song, @Context UriInfo uriInfo){
        int id = Songs.create(song.getName(), song.getSinger());

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(String.valueOf(id));

        URI uri = uriBuilder.build();

        return Response.created(uri).build();
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id){

        if (findSongById(id) == null){
            return Response.notModified().build();
        }
        Songs.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Song song, @Context UriInfo uriInfo){

        if (findSongById(song.getId()) == null){
            return Response.notModified().build();
        }

        Songs.update(song.getId(), song.getName(), song.getSinger());
        return Response.ok().build();
    }
}
