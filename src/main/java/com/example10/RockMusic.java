package com.example10;

public class RockMusic implements Music {

    public void doMyInit(){
        System.out.println("do my initialization");
    }

    public void doDestroy(){
        System.out.println("do my destroying");
    }

    @Override
    public String getSong() {
        return "Rock music";
    }
}
