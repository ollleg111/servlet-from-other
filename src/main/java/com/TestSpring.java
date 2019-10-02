package com;

import com.ddd.Music;
import com.ddd.MusicPlayer;
//import com.ccc.MusicPlayer;
//import com.bbb.MusicPlayer;
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

        // -ddd
        // данные через set + передаем List

        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        MusicPlayer musicPlayer = classContext.getBean("musicPlayer3", MusicPlayer.class);
        musicPlayer.playMusic();

        classContext.close();

    }
}
