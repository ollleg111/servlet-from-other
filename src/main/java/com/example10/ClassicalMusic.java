package com.example10;

public class ClassicalMusic implements Music {

    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

    @Override
    public String getSong() {
        return "Classic music";
    }
}
