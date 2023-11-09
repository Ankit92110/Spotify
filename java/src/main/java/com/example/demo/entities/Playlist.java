package com.example.demo.entities;

import java.util.List;

public class Playlist {
    private Long id;
    private String name;
    private List<Long>songsList;
    public Playlist(String name, List<Long> songsId) {
        this.name = name;
        this.songsList = songsId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Long> removeSong(Long id){
        this.songsList.remove(id);
        return this.songsList;
    }
    public List<Long> getSongsList() {
        return this.songsList;
    }
    public void setSongsId(List<Long> songsList) {
        this.songsList = songsList;
    }
    public void addsong(Long songId){
        this.songsList.add(songId);
    }
    
    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((songsList == null) ? 0 : songsList.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Playlist other = (Playlist) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (songsList == null) {
            if (other.songsList != null)
                return false;
        } else if (!songsList.equals(other.songsList))
            return false;
        return true;
    }
    
    
}
