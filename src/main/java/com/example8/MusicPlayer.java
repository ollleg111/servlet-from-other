package com.example8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("musicPlayer8")
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

//    @Value("${musicPlayer.name}")
//    private String name;
//
//    @Value("${musicPlayer.value}")
//    private int volume;
//
//    public String getName() {
//        return name;
//    }
//
//    public int getVolume() {
//        return volume;
//    }


    // пример с констуктором
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
