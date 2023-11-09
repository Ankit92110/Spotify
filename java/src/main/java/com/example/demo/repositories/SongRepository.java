package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import com.example.demo.entities.Song;

public class SongRepository implements IsongReposiotry{
    private final Map<Long,Song> songMap;
    private Long autoIncrement = 1L;

    public SongRepository(){
        songMap = new HashMap<>();
    }

    public Map<Long, Song> getSongMap() {
        return songMap;
    }

    @Override
    public List<Song> findAll() {
        // TODO Auto-generated method stub
     return   songMap.values().stream().collect(Collectors.toList());
       
    }


    @Override
    public Song save(Song song) {
        // TODO Auto-generated method stub
        if(song.getId()==null) 
             song.setId(autoIncrement);
             songMap.put(autoIncrement,song);
             autoIncrement++;
             return song;

    }
    
}
