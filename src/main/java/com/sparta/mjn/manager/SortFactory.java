package com.sparta.mjn.manager;

import com.sparta.mjn.sorters.BubbleSorter;
import com.sparta.mjn.sorters.MergeSorter;
import com.sparta.mjn.sorters.QuickSorter;
import com.sparta.mjn.sorters.Sorter;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class SortFactory {
    private static final String PATH = "resources/sort.properties";
    private static final String KEY = "sort";
    private static Logger log = Logger.getLogger(SortFactory.class.getName());

    public static Sorter getInstance(){
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(PATH));
            String sortType = properties.getProperty(KEY);
            Class selectedSorter = Class.forName(sortType);
            return (Sorter) selectedSorter.getDeclaredConstructor().newInstance();
    } catch (IOException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException  e) {
            System.out.println("File not found ");
            log.error(e);
            return new BubbleSorter();
        }
        }
    }
