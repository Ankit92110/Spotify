package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;

public interface IplayListReposiotry {
    Playlist save(Playlist song);
    List<Long> addSongToPlayList(String name,Long id);
    List<Long> deleteSongFromPlayList(String name,Long id);
    void deletePlayList(String name);
    Playlist loadPlayList(String name);
}
