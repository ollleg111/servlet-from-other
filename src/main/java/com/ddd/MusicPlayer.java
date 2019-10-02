package com.ddd;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> music = new ArrayList();
    private String name;
    private int volume;

    public MusicPlayer() {
    }

    public MusicPlayer(List<Music> music, String name, int volume) {
        this.music = music;
        this.name = name;
        this.volume = volume;
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusic() {
        System.out.println("Playing: ");
        for (Music music : getMusic()) {
            System.out.print(music.getSong() + ", ");
        }
    }
}
