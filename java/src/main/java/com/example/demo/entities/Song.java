package com.example.demo.entities;

public class Song {
    private Long id;
    private String name;
    private String artist;
    private String album;
    private String genre;
    public Song(String name, String artist, String album, String genre) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
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


    public String getArtist() {
        return artist;
    }


    public void setArtist(String artist) {
        this.artist = artist;
    }


    public String getAlbum() {
        return album;
    }


    public void setAlbum(String album) {
        this.album = album;
    }


    public String getGenre() {
        return genre;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "Song [id=" + id + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((album == null) ? 0 : album.hashCode());
        result = prime * result + ((artist == null) ? 0 : artist.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Song other = (Song) obj;
        if (album == null) {
            if (other.album != null)
                return false;
        } else if (!album.equals(other.album))
            return false;
        if (artist == null) {
            if (other.artist != null)
                return false;
        } else if (!artist.equals(other.artist))
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
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
        return true;
    }

}
