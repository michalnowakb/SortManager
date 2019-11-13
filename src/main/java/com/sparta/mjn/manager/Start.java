package com.sparta.mjn.manager;


import com.sparta.mjn.sorters.BubbleSorter;
import com.sparta.mjn.sorters.MergeSorter;
import com.sparta.mjn.sorters.QuickSorter;

import java.util.Arrays;

public class Start
{
    public static void main( String[] args )
    {


        new SortManager().sortArray();
//
//        MergeSorter mergeSorter = new MergeSorter();
//        int [] sortedArray = mergeSorter.getSortedArray(arrayToSort);
//        System.out.println("Array before sorting: " + Arrays.toString(arrayToSort));
//        System.out.println("Sorted Array: " +  Arrays.toString(sortedArray));
//
    }
}
