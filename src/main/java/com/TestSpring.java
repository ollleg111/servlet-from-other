package com;

import com.example10.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        // - aaa
        /*
                ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        TestBean testBean = classContext.getBean("testingBean", TestBean.class);
        System.out.println(testBean.getName());
        classContext.close();
         */

        /*
        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Music music = classContext.getBean("musicBean", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);

        MusicPlayer musicPlayer = new MusicPlayer(classContext.getBean("musicBean", Music.class));
        musicPlayer.playMusic();
        classContext.close();
         */
// ------------------------------------------------------

        // реализация DEPENDENCY INJECTION
        // -bbb
        // передача бина с помощью конструтора в качестве аргумента
        // в xml в бине конструкция - <constructor>
        /*
        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        MusicPlayer musicPlayer = classContext.getBean("musicPlayer2", MusicPlayer.class);
        musicPlayer.playMusic();
         */
//------------------------------------------------------

        // -ccc
        // передача бина с set (сетера) в качестве аргумента
        // в xml в бине конструкция - <property>

        /*
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());
        classContext.close();
         */
//------------------------------------------------------

        // возможность вводить данные в сеттер из внешнего файла расположенного в ресурсах
        // создается файл - musicPlayer.properties

        /*
        <context:property-placeholder location="classpath:musicPlayer.properties"/>
        <property name="name" value="${musicPlayer.name}"/>
        <property name="volume" value="${musicPlayer.volume}"/>
         */

        // данные поступают из файла

        /*
                musicPlayer.name=Some name2
                musicPlayer.volume=70
         */
//--------------------------------------------------------

        // -ddd
        // данные через set + передаем List

        /*
                ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        MusicPlayer musicPlayer = classContext.getBean("musicPlayer3", MusicPlayer.class);
        musicPlayer.playMusic();

        classContext.close();
         */
// --------------------------------------------------------

        // -eee
        // это СИНГЛТОН !!!!! всегда возвращается один и тот же объект
        // при использовании скопе - синглтон (по умолчанию) инициализация один раз и дестрой - один раз

        /*
        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        RockMusic rockMusic = classContext.getBean("music", RockMusic.class);
        System.out.println("Singing: The " + rockMusic.getSong());

        RockMusic rockMusic1 = classContext.getBean("music", RockMusic.class);
        System.out.println("Singing: The " + rockMusic1.getSong());

        classContext.close();
         */
// --------------------------------------------------------

        // -example4
//        //для бинов со скопом prototype Spring не вызывает destroy метод
//        //при использовании скоп - прототип - инициализация при каждом обращении к бину

        /*
                PopMusic popMusic = classContext.getBean("musicWithPrototype", PopMusic.class);
        System.out.println("Singing: The " + popMusic.getSong());

        PopMusic popMusic1 = classContext.getBean("musicWithPrototype", PopMusic.class);
        System.out.println("Singing: The " + popMusic1.getSong());

        classContext.close();
         */
// --------------------------------------------------------

        //пример реализации методов инит и дестрой, они прописываются в бине
        //<bean id="music" class="com.example4.ClassicalMusic" init-method="doMyInit" destroy-method="doDestroy"/>
        //<bean id="musicWithPrototype" class="com.example4.PopMusic" init-method="doMyInit" destroy-method="doDestroy" scope="prototype"/>
// --------------------------------------------------------

        // -example4
        // использование фабричного метода
        // в классе ClassicalMusic делаем приватный консктруктор
        // прописываем фабричный метод в бине
        // <bean id="musicWithFabric" class="com.example4.ClassicalMusic" factory-method="getClassicalMusic"/>

        /*
             ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Music classicalMusic = classContext.getBean("musicWithFabric", ClassicalMusic.class);
        System.out.println("Singing: The " + classicalMusic.getSong());

        classContext.close();
         */

        //  у фабричного метода скоп - синглтон
// --------------------------------------------------------

        // -example5
        // использование аннотаций
        // <context:component-scan base-package="com.example5"/>
        // если не указывать id  в аннтотации, то название бина сгенерится из названия класса с уменьшением букв
        // ClassicalMusic - в classicalMusic

        /*
                ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        Music music = classContext.getBean("classicalMusic", ClassicalMusic.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);
        musicPlayer.playMusic();

        Music music1 = classContext.getBean("rockMusic", RockMusic.class);
        MusicPlayer musicPlayer1 = new MusicPlayer(music1);
        musicPlayer1.playMusic();

        classContext.close();
         */
// --------------------------------------------------------

        // -example6
        // внедрение зависимостей через @Autowired
        // убераем создание MusicPlayer через new
        // внедрить @Autowired можно перед полем, сетером или конструктором

        /*
                ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        MusicPlayer musicPlayer = classContext.getBean("musicPlayer6", MusicPlayer.class);
        musicPlayer.playMusic();

        // добавление нового класса бином и подключение к нему
        Computer computer = classContext.getBean("computer", Computer.class);
        System.out.println(computer);
        classContext.close();
         */
// --------------------------------------------------------

        // -example7
        // уточнение зависимости через @Qualifier

//        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );
//        Computer computer = classContext.getBean("computer", Computer.class);
//        System.out.println(computer);
//
//        classContext.close();
        // --------------------------------------------------------

        // -example8
        // добавление новых аннотаций

        /*
        ClassPathXmlApplicationContext classContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Computer computer = classContext.getBean("computer", Computer.class);
        System.out.println(computer);

//        MusicPlayer musicPlayer = classContext.getBean("musicPlayer8", MusicPlayer.class);
//        musicPlayer.getName();
//        musicPlayer.getVolume();

        // проверка анноации @Scope - singleton
        ClassicalMusic classicalMusic1 = classContext.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = classContext.getBean("classicalMusic", ClassicalMusic.class);

        System.out.println("__________________________________");
        System.out.println(classicalMusic1 == classicalMusic2);
        System.out.println("__________________________________");

        // проверка анноации @Scope - prototype
        RockMusic rockMusic1 = classContext.getBean("rockMusic", RockMusic.class);
        RockMusic rockMusic2 = classContext.getBean("rockMusic", RockMusic.class);

        System.out.println(rockMusic1 == rockMusic2);
        System.out.println("__________________________________");

        classContext.close();
         */
        // --------------------------------------------------------

        // -example9
        // создание бинов через java контекст, но с аннотациями
        /*
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);

        MusicPlayer musicPlayer = context.getBean("musicPlayer9", MusicPlayer.class);
        System.out.println("Name: " + musicPlayer.getName());
        System.out.println("Volume: " + musicPlayer.getVolume());

        // проверка анноации @Scope - singleton
        ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);

        System.out.println("__________________________________");
        System.out.println(classicalMusic1 == classicalMusic2);
        System.out.println("__________________________________");

        // проверка анноации @Scope - prototype
        RockMusic rockMusic1 = context.getBean("rockMusic", RockMusic.class);
        RockMusic rockMusic2 = context.getBean("rockMusic", RockMusic.class);

        System.out.println(rockMusic1 == rockMusic2);
        System.out.println("__________________________________");

        context.close();
        */

        // -example10
        // создание бинов через java контекст, ВРУЧНУЮ в файлке конфигурации
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println("Name: " + musicPlayer.getName());
        System.out.println("Volume: " + musicPlayer.getVolume());

        // проверка анноации @Scope - singleton
        ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);

        System.out.println("__________________________________");
        System.out.println(classicalMusic1 == classicalMusic2);
        System.out.println("__________________________________");

        // проверка анноации @Scope - prototype
        RockMusic rockMusic1 = context.getBean("rockMusic", RockMusic.class);
        RockMusic rockMusic2 = context.getBean("rockMusic", RockMusic.class);

        System.out.println(rockMusic1 == rockMusic2);
        System.out.println("__________________________________");

        context.close();
    }
}
