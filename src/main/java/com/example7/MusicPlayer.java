package com.example7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("musicPlayerExample7")
public class MusicPlayer {
    // пример с полем
    /*
    @Autowired
    @Qualifier("rockMusic")
    private Music music;

    public String playMusic() {
        return "Playing: " + music.getSong();
    }
     */

    // пример с констркктором

    Music music1, music2, music3;

    @Autowired
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
