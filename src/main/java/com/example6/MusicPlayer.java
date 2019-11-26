package com.example6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("musicPlayerExample6")
public class MusicPlayer {

//    private Music music;
//
//    @Autowired
//    public MusicPlayer(Music music) {
//        this.music = music;
//    }

//    public void playMusic() {
//        System.out.println("Playing: " + music.getSong());
//    }

    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

        public String playMusic() {
        return ("Playing: " + classicalMusic.getSong() + " and " +
                rockMusic.getSong());
    }
}
