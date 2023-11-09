package com.example.demo.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.example.demo.entities.Song;

public interface IsongReposiotry {
    Song save(Song song);
    List<Song> findAll();
    Map<Long,Song> getSongMap();
}
