package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IsongService;

public class PreviousSongCommand implements ICommand {
    private IsongService songService;
    

    public PreviousSongCommand(IsongService songService) {
        this.songService = songService;
    }


    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        songService.previousSong();
        
    }
    
    
}
