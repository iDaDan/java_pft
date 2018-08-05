package ru.stqa.pft.sandbox.sandboxCDBP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main (String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP" };

        /* String[] langs2 = new String[4];
        langs2[0] = "Java";
        langs2[1] = "C#";
        langs2[2] = "Python";
        langs2[3] = "PHP";*/

/*        for (int i = 0; i < langs.length; i++) {
            System.out.println("Я хочу выучить" + langs[i]);
        }*/

        for (String l : langs){
            System.out.println("Я хочу выучить " + l);
        }


        /*List<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");

         for (String l : languages){
            System.out.println("Я хочу выучить " + l);
        }

        */

        /*List<String> langs3 = Arrays.asList("Java", "C#", "Python", "PHP");*/
/*
            for (int i = 0; i < langs3.size(); i++){
            System.out.println("Я хочу выучить " + languages.get(i));
        }*/

       /*
       //Тоже сработает и лучше выглядит
       for (String l : langs3){
            System.out.println("Я хочу выучить " + l);
        }*/

    }
}
