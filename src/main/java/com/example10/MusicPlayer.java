package com.example10;

import org.springframework.beans.factory.annotation.Qualifier;

public class MusicPlayer {

    private String name;
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }


    // пример с констуктором
    Music music1, music2, music3;

    public MusicPlayer(@Qualifier("classicalMusic") Music music1,
                       @Qualifier("rockMusic") Music music2,
                       @Qualifier("popMusic") Music music3) {
        this.music1 = music1;
        this.music2 = music2;
        this.music3 = music3;
    }

    public String playMusic() {
        return "Playing: " +
                music1.getSong() + ", " +
                music3.getSong() + ", " +
                music2.getSong();
    }
}
