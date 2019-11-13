package com.sparta.mjn.display;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DisplayManager {

    Scanner scanner = new Scanner(System.in);
    Scanner arraySize = new Scanner(System.in);

    public String displayTerminalSortTypeRequest(String path){
        System.out.println("Enter the number of the sorter you with to use: ");
        String[] sortNames = getMenuItems(path);
        int sortType = scanner.nextInt();
        return sortNames[sortType-1];
    }

    private String[] getMenuItems(String path) {
        File sortDirectory = new File(path);
        List<String> namesAsList = Arrays.asList(sortDirectory.list());
        List<String> sortedList = namesAsList.stream()
                .filter(fileName -> !fileName.equals("Sorter.java"))
                .sorted()
                .collect(Collectors.toList());

                sortedList.stream()
                .map(fileName -> fileName.substring(0,fileName.indexOf(".")))
                .forEach(fileName -> System.out.println((sortedList.indexOf(fileName + ".java")+1) + ". " + fileName));
//        String[] names = sortDirectory.list(filterDir,filename) ->;
//        Arrays.sort(names != null ? names : new String[0]);
//        int index = 1;
//        for (String name : names) {
//            if (!name.equals("Sorter.java")) {
//                name = name.substring(0, name.indexOf("."));
//                System.out.println(index + ". " + name);
//                index++;
//            }
//        }
        return sortedList.toArray(new String[sortedList.size()]);
    }

    public void displaySortedArray(int[] unsortedArray, int[] sortedArray, String sortType) {
        System.out.println("Unsorted Array: " + Arrays.toString(unsortedArray));
        System.out.println("Sorted using " + sortType);
        System.out.println(Arrays.toString(sortedArray));
    }

    public int displayTerminalSortTypeRequest(){
        System.out.println("Enter how many elements would you like to have in your Array: ");
        int size = arraySize.nextInt();
        return size;
    }
}
