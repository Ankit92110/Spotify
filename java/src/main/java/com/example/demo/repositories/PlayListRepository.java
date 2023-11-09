package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
public class PlayListRepository implements IplayListReposiotry{
    private final Map<String,Playlist> playListMap;
    private Long autoIncrement = 1L;
    public PlayListRepository() {
        playListMap=new HashMap<>();
    }
    @Override
    public Playlist save(Playlist playList) {
        // TODO Auto-generated method stub
        if(playList.getId()==null) 
        playList.setId(autoIncrement);
        playListMap.put(playList.getName(),playList);
        autoIncrement++;
        return playList;
    }
   
    @Override
    public void deletePlayList(String name) {
        // TODO Auto-generated method stub
        playListMap.remove(name);
        
    }
    @Override
    public List<Long> deleteSongFromPlayList(String name, Long id) {
        // TODO Auto-generated method stub
        return this.playListMap.get(name).removeSong(id);
    }
    @Override
    public Playlist loadPlayList(String name) {
        // TODO Auto-generated method stub
        return playListMap.get(name);
        
    }
    @Override
    public List<Long> addSongToPlayList(String name, Long id) {
        // TODO Auto-generated method stub
        playListMap.get(name).addsong(id);
        return playListMap.get(name).getSongsList();

    }
  
    

    
}
