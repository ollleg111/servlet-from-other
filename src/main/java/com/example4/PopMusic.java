package com.example4;

public class PopMusic implements Music {

    public void doMyInit(){
        System.out.println("do my initialization");
    }

    public void doDestroy(){
        System.out.println("do my destroying");
    }

    @Override
    public String getSong() {
        return "Pop music";
    }
}
