package com.example5;

import org.springframework.stereotype.Component;

@Component("rockMusic")
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
