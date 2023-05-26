package entity;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
private String name;
private String singer;
private String songURL;

    public Song() {
    }

    public Song(int id, String name, String singer, String songURL) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.songURL = songURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongURL() {
        return songURL;
    }

    public void setSongURL(String songURL) {
        this.songURL = songURL;
    }
}
