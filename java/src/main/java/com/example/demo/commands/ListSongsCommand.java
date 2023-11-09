package com.example.demo.commands;

import java.util.List;
import javax.swing.Icon;
import com.example.demo.services.IsongService;

public class ListSongsCommand implements ICommand{
    private IsongService songService;
    

    public ListSongsCommand(IsongService songService) {
        this.songService = songService;
    }


    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        songService.listSong();
        
    }
    
    
}
