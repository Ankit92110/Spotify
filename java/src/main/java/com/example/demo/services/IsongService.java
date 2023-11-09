package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;

public interface IsongService {
    public void addSong(List<String>tokens);
    public void createPlayList(List<String>tokens);
    public void addSongToPlayList(List<String>Tokens);
    public void deleteSongFromPlayList(List<String>Tokens);
    public void deletePlayList(List<String>Tokens);
    public void loadPlayList(List<String>tokes);
    public void playSong();
    public void nextSong();
    public void previousSong();
    public void stopSong();
    public void listSong();
    
}
