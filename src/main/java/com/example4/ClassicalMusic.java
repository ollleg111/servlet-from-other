package com.example4;

public class ClassicalMusic implements Music {

    private ClassicalMusic(){
    }

    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

    @Override
    public String getSong() {
        return "Classic music!";
    }
}
