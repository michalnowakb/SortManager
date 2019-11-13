package com.sparta.mjn.manager;

import com.sparta.mjn.sorters.Sorter;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class SortLoader {
    private String name;
    private static final String SRC = "/src/main/java/";
    {
        String classpath = Sorter.class.getName();
        name = classpath.substring(0,classpath.lastIndexOf('.'));
    }

    public String getSortersLocation(){
        String classpathStr = System.getProperty("user.dir");
        String classpath = classpathStr + SRC + name.replace('.','/');
        return classpath;
    }

    public Sorter getSorter(String sortType){
        try{
            String sorterName = name + "." + sortType.substring(0,sortType.lastIndexOf('.'));
            Class selectedSorter = Class.forName(sorterName);
            return (Sorter) selectedSorter.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            return null;
        }
    }

//    final String PATH = "C:\\Users\\Michal Nowak\\IdeaProjects\\SortManager\\src\\main\\java\\com\\sparta\\mjn\\sorters"
//
}
