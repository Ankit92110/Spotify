package com.example.demo.commands;

import java.util.List;
import com.example.demo.repositories.IsongReposiotry;
import com.example.demo.services.IsongService;

public class AddSongToPlayListCommand implements ICommand{
    private IsongService songService;
    
    public AddSongToPlayListCommand(IsongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        songService.addSongToPlayList(tokens);  
    }
    
    
}
