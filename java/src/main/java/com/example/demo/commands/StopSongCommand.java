package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IsongService;

public class StopSongCommand implements ICommand {
    private IsongService songService;
    

    public StopSongCommand(IsongService songService) {
        this.songService = songService;
    }


    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        songService.stopSong();
        
    }
    
    
}
