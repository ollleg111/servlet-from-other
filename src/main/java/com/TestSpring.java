package com;

import com.example4.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        // - aaa
//        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );
//        TestBean testBean = classContext.getBean("testingBean", TestBean.class);
//        System.out.println(testBean.getName());
//        classContext.close();

        // -bbb
        // передача бина с помощью конструтора в качестве аргумента
        // в xml в бине конструкция - <constructor>

//        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );
//        MusicPlayer musicPlayer = new MusicPlayer(classContext.getBean("musicBean", Music.class));
//        musicPlayer.playMusic();
//        classContext.close();
//------------------------------------------------------
        // -ccc
        // передача бина с set (сетера) в качестве аргумента
        // в xml в бине конструкция - <property>

//        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );
//        MusicPlayer musicPlayer = classContext.getBean("musicPlayer2", MusicPlayer.class);
//        musicPlayer.playMusic();
//        System.out.println(musicPlayer.getName());
//        System.out.println(musicPlayer.getVolume());
//        classContext.close();

        // возможность вводить данные в сеттер из внешнего файла расположенного в ресурсах
        // создается файл - musicPlayer.properties

//        <context:property-placeholder location="classpath:musicPlayer.properties"/>
//        <property name="name" value="${musicPlayer.name}"/>
//        <property name="volume" value="${musicPlayer.volume}"/>

        //данные поступают из файла
//        musicPlayer.name=Some name2
//        musicPlayer.volume=70
//--------------------------------------------------------
        // -ddd
        // данные через set + передаем List

//        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );
//        MusicPlayer musicPlayer = classContext.getBean("musicPlayer3", MusicPlayer.class);
//        musicPlayer.playMusic();
//
//        classContext.close();

        // -eee
        //пример реализации методов инит и дестрой, они прописываются в бине
        //<bean id="music" class="com.example4.ClassicalMusic" init-method="doMyInit" destroy-method="doDestroy"/>

        //при использовании скопе - синглтон (по умолчанию) инициализауия один и дестрой - один раз

//        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );
//
//        RockMusic rockMusic = classContext.getBean("music", RockMusic.class);
//        System.out.println("Singing: The " + rockMusic.getSong());
//
//        RockMusic rockMusic1 = classContext.getBean("music", RockMusic.class);
//        System.out.println("Singing: The " + rockMusic1.getSong());
//
//        System.out.println("-----------------------------------");
//        //для бинов со скопом prototype Spring не вызывает destroy метод
//        //при использовании скоп - прототип - инициализация при каждом обращении к бину
//        //<bean id="musicWithPrototype" class="com.example4.PopMusic" init-method="doMyInit" destroy-method="doDestroy" scope="prototype"/>
//
//        PopMusic popMusic = classContext.getBean("musicWithPrototype", PopMusic.class);
//        System.out.println("Singing: The " + popMusic.getSong());
//
//        PopMusic popMusic1 = classContext.getBean("musicWithPrototype", PopMusic.class);
//        System.out.println("Singing: The " + popMusic1.getSong());
//
//        classContext.close();

        // -fff
        //использование фабричного метода
        //в классе ClassicalMusic делаем приватный консктруктор
        //прописываем фабричный метод в бине
//        <bean id="musicWithFabric" class="com.example4.ClassicalMusic" factory-method="getClassicalMusic"/>
        //это СИНГЛТОН !!!!! всегда возвращается один и тот же объект


        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Music classicalMusic = classContext.getBean("musicWithFabric", ClassicalMusic.class);
        System.out.println("Singing: The " + classicalMusic.getSong());

        classContext.close();
    }
}
