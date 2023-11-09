package com.example.demo;

import com.example.demo.commands.AddSongCommand;
import com.example.demo.commands.AddSongToPlayListCommand;
import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.CreatePlaylistCommand;
import com.example.demo.commands.DeletePlayListCommand;
import com.example.demo.commands.DeleteSongFromPlayListCommand;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.ListSongsCommand;
import com.example.demo.commands.LoadPlayListCommand;
import com.example.demo.commands.NextSongCommand;
import com.example.demo.commands.PlaySongCommand;
import com.example.demo.commands.PreviousSongCommand;
import com.example.demo.commands.StopSongCommand;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.IplayListReposiotry;
import com.example.demo.repositories.IsongReposiotry;
import com.example.demo.repositories.PlayListRepository;
import com.example.demo.repositories.SongRepository;
import com.example.demo.services.GreetingService;
import com.example.demo.services.IsongService;
import com.example.demo.services.SongService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IGreetingRepository greetingRepository = new GreetingRepository();
            private final IsongReposiotry songReposiotry=new SongRepository();
            private final IplayListReposiotry playListReposiotry=new PlayListRepository();
    
            // Initialize services
            private final GreetingService greetingService = new GreetingService(greetingRepository);
            private final IsongService songService=new SongService(songReposiotry, playListReposiotry);


            // Initialize commands
            private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);
            private final AddSongCommand addSongCommand=new AddSongCommand(songService);
            private final ListSongsCommand listSongsCommand=new ListSongsCommand(songService);
            private final CreatePlaylistCommand createPlaylistCommand=new CreatePlaylistCommand(songService);
            private final LoadPlayListCommand loadPlayListCommand=new LoadPlayListCommand(songService);
            private final PlaySongCommand playSongCommand=new PlaySongCommand(songService);
            private final NextSongCommand nextSongCommand=new NextSongCommand(songService);
            private final PreviousSongCommand previousSongCommand=new PreviousSongCommand(songService);
            private final StopSongCommand stopSongCommand=new StopSongCommand(songService);
            private final DeletePlayListCommand deletePlayListCommand=new DeletePlayListCommand(songService);
            private final AddSongToPlayListCommand addSongToPlayListCommand=new AddSongToPlayListCommand(songService);
            private final DeleteSongFromPlayListCommand deleteSongFromPlayListCommand =new DeleteSongFromPlayListCommand(songService);

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);
              
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_COMMAND.getName(),addSongCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_SONGS_COMMAND.getName(),listSongsCommand);
                commandRegistry.registerCommand(CommandKeyword.CREATE_PLAYLIST_COMMAND.getName(),createPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST_COMMAND.getName(),loadPlayListCommand);
                commandRegistry.registerCommand(CommandKeyword.PLAY_SONG_COMMAND.getName(),playSongCommand);
                commandRegistry.registerCommand(CommandKeyword.NEXT_SONG_COMMAND.getName(),nextSongCommand);
                commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG_COMMAND.getName(),previousSongCommand);
                commandRegistry.registerCommand(CommandKeyword.STOP_SONG_COMMAND.getName(),stopSongCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_PLAYLIST_COMMAND.getName(),deletePlayListCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST_COMMAND.getName(),addSongToPlayListCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST_COMMAND.getName(),deleteSongFromPlayListCommand);
                

            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
