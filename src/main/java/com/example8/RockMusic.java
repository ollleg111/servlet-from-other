package com.example8;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("rockMusic")
@Scope("prototype")
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
