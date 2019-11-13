package com.sparta.mjn;

import com.sparta.mjn.sorters.BubbleSorter;
import com.sparta.mjn.sorters.MergeSorter;
import com.sparta.mjn.sorters.QuickSorter;
import com.sparta.mjn.sorters.Sorter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class PerformanceTester {

    private int[] unsortedArray;
    private static int[] arrayToSort;

    @BeforeClass
    public static void classSetup(){
        Random random = new Random();
        arrayToSort = new int[10000];
        for(int i = 0; i < arrayToSort.length; i++){
            arrayToSort[i] = random.nextInt(arrayToSort.length*10) + 1;
        }
    }
    @Before
    public void Setup(){
        unsortedArray = arrayToSort.clone();
    }

    @Test
    public void testBubbleSorter(){
        System.out.println("*************************" + Arrays.toString(unsortedArray));
        Sorter sorter = new BubbleSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.getSortedArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.toString(),end - start, sortedArray);
    }

    @Test
    public void testMergeSorter(){
        System.out.println("*************************" + Arrays.toString(unsortedArray));
        Sorter sorter = new MergeSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.getSortedArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.toString(),end - start, sortedArray);
    }

    @Test
    public void testQuickSorter(){
        System.out.println("*************************" + Arrays.toString(unsortedArray));
        Sorter sorter = new QuickSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.getSortedArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter.toString(),end - start, sortedArray);
    }

    private void printResults(String sorter, long time, int[] sortedArray){
        DecimalFormat decimalFormat = new DecimalFormat("###,###.####");
        System.out.println(sorter + ":");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("Time taken " + (decimalFormat.format(time) + " nano seconds"));

    }
}
