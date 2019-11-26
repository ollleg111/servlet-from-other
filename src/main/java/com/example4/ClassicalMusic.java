package com.example4;

public class ClassicalMusic implements Music {

    // ограничиваем взможность создания объектов при помощи new - создаем приватный конструктор
    private ClassicalMusic(){
    }

    // делаем статический метод, который будет возвращать экземпляр класса и прописываем его кв контексте
    // factory-method="getClassicalMusic"
    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

    public void doMyInit(){
        System.out.println("do my initialization");
    }

    public void doDestroy(){
        System.out.println("do my destroying");
    }

    @Override
    public String getSong() {
        return "Classic music!";
    }
}
