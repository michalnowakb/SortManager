package com.sparta.mjn.manager;

import com.sparta.mjn.display.DisplayManager;
import com.sparta.mjn.search.BinarySearchTree;
import com.sparta.mjn.sorters.Sorter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Random;

public class SortManager {
    private static Logger log = Logger.getLogger(SortManager.class.getName());

    private DisplayManager displayManager = new DisplayManager();
    private SortLoader loader = new SortLoader();




    public void sortArray(){
        String sortType = displayManager.displayTerminalSortTypeRequest(loader.getSortersLocation());
        int sizeOfArray = displayManager.displayTerminalSortTypeRequest();
        int[] unsortedArray = createArray(sizeOfArray);

        LoggingManager loggingManager = new LoggingManager();
        loggingManager.initialiseLogging();

        Sorter sorter = getSorter(sortType);
        int[] sortedArray = sorter.getSortedArray(unsortedArray.clone());
        displaySortedArray(unsortedArray, sortedArray, sorter.toString());
    }

//    public void sortArray(){
//        try{
//            String sortType = displayManager.displayTerminalSortTypeRequest(loader.getSortersLocation());
//            String sizeOfArray = displayManager.displayTerminalSortTypeRequest();
//
//            int[] arrayTosSort = createArray(Integer.parseInt(sizeOfArray));
//
//        }
//    }



    private void displaySortedArray(int[] unsortedArray, int[] sortedArray, String sortType){
        DisplayManager displayManager = new DisplayManager();
        displayManager.displaySortedArray(unsortedArray, sortedArray,sortType);
    }

    private int[] createArray(int size){
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for(int i = 0; i < size; i++){
            unsortedArray[i] = random.nextInt(size * 10) + 1;
        }
        return unsortedArray;
    }

    private Sorter getSorter(String sortType){
        return loader.getSorter(sortType);
    }

}
