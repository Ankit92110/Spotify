package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IplayListReposiotry;
import com.example.demo.repositories.IsongReposiotry;
import com.example.demo.repositories.SongRepository;

public class SongService implements IsongService {
    private IsongReposiotry songReposiotry;
    private IplayListReposiotry playListReposiotry;
    private Playlist playList=null;
    private int currentsong= 0;
    private boolean status=false;
    public SongService(IsongReposiotry songReposiotry,IplayListReposiotry pListReposiotry) {
        this.songReposiotry = songReposiotry;
        this.playListReposiotry=pListReposiotry;
    }

    @Override
    public void addSong(List<String> tokens) {
        // TODO Auto-generated method stub
        Song song=new Song(tokens.get(1),tokens.get(2),tokens.get(3),tokens.get(4));
        System.out.println(songReposiotry.save(song));
        
    }

    @Override
    public void addSongToPlayList(List<String> Tokens) {
          List<Song>songs=new ArrayList<>();
          List<Long>songsId=playListReposiotry.addSongToPlayList(Tokens.get(1),Long.parseLong(Tokens.get(2)));
          for(Long id:songsId){
            songs.add(songReposiotry.getSongMap().get(id));
          }
          System.out.println("Playlist PLAYLIST_2 is revised with "+songs);
    }

    @Override
    public void createPlayList(List<String> tokens) {
        // TODO Auto-generated method stub
        List<Long> songsId = new ArrayList<>();
        for (int i = 2; i < tokens.size(); i++) {
            songsId.add(Long.parseLong(tokens.get(i)));
        }

        Playlist playList=new Playlist(tokens.get(1), songsId);
        System.out.println(playListReposiotry.save(playList));

        
    }

    @Override
    public void deletePlayList(List<String> Tokens) {
        // TODO Auto-generated method stub
        playListReposiotry.deletePlayList(Tokens.get(1));
        System.out.println("Playlist "+Tokens.get(1)+" is deleted!");
    }

    @Override
    public void deleteSongFromPlayList(List<String> Tokens) {
        // TODO Auto-generated method stub
        List<Song>songs=new ArrayList<>();
        List<Long>songsId=playListReposiotry.deleteSongFromPlayList(Tokens.get(1),Long.parseLong(Tokens.get(2)));
        for(Long id:songsId){
          songs.add(songReposiotry.getSongMap().get(id));
        }
        System.out.println("Playlist "+Tokens.get(1)+" is revised with " +songs);
        
    }

    @Override
    public void listSong() {
        // TODO Auto-generated method stub
        System.out.println(songReposiotry.findAll());
    }

    @Override
    public void loadPlayList(List<String> tokens) {
        // TODO Auto-generated method stub
        playList=playListReposiotry.loadPlayList(tokens.get(1));
        this.currentsong= 0;
        this.status=false;
        System.out.println("Playlist "+tokens.get(1)+" is loaded!");
    }

    @Override
    public void nextSong() {
        // TODO Auto-generated method stub
        currentsong=(currentsong+1)%playList.getSongsList().size();
        Long index=playList.getSongsList().get(currentsong);
        System.out.println(songReposiotry.getSongMap().get(index)+" is playing!");
        
    }

    @Override
    public void playSong() {
        // TODO Auto-generated method stub
     
        Long index=playList.getSongsList().get(currentsong);
        if(this.status)
        System.out.println(songReposiotry.getSongMap().get(index)+" is paused!");
        else
         System.out.println(songReposiotry.getSongMap().get(index)+" is playing!");
         this.status=true;
        
    }

    @Override
    public void previousSong() {
        // TODO Auto-generated method stub
        currentsong--;
        if(currentsong<0) currentsong=playList.getSongsList().size()-1;
        Long index=playList.getSongsList().get(currentsong);
        System.out.println(songReposiotry.getSongMap().get(index)+" is playing!");
        
    }

    @Override
    public void stopSong() {
        // TODO Auto-generated method stub

        Long index=playList.getSongsList().get(currentsong);
        System.out.println(songReposiotry.getSongMap().get(index)+" is stopped!");   
        
    }
    
    
}
