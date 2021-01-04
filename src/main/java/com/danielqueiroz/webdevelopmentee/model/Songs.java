package com.danielqueiroz.webdevelopmentee.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Mock Datasource
public class Songs {

    private static int CURRENT_ID = 0;

    private static final Map<Integer, Song> songs = new LinkedHashMap<>();

    static {
        songs.put(++CURRENT_ID, new Song(CURRENT_ID, "Let It be", "Beatles"));
        songs.put(++CURRENT_ID, new Song(CURRENT_ID, "Hey Jude", "Beatles"));
        songs.put(++CURRENT_ID, new Song(CURRENT_ID, "Crazy", "Aerosmith"));
        songs.put(++CURRENT_ID, new Song(CURRENT_ID, "Angel", "Aerosmith"));
        songs.put(++CURRENT_ID, new Song(CURRENT_ID, "Snurf", "Slipknot"));
    }

    public static List<Song> list(){
        return new ArrayList<Song>(songs.values());
    }

    public static Song findById(int id){
        return songs.get(id);
    }

    public static int create(String name, String singer){
        Song song = new Song(++CURRENT_ID, name, singer);
        songs.put(CURRENT_ID, song);
        return CURRENT_ID;
    }

    public static void delete(int id){
        songs.remove(id);
    }

    public static void update(int id, String name, String singer){
        Song song = findById(id);
        if (song != null){
            song.setName(name);
            song.setSinger(singer);
        }
    }

}
