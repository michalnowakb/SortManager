package com.sparta.mjn.sorters;

import java.util.Arrays;

public class MergeSorter implements Sorter {


    @Override
    public int[] getSortedArray(int[] arrayToSort) {
        int idexOfFirst = 0;
        int[] firstArray;
        int[] secondArray;

        if (arrayToSort == null) {
            return null;
        }

        if (arrayToSort.length <= 1) {
            return arrayToSort;
        }

        if (arrayToSort.length % 2 == 0) {
            idexOfFirst = arrayToSort.length / 2;
        } else {
            idexOfFirst = (arrayToSort.length + 1) / 2;
        }

        firstArray = Arrays.copyOfRange(arrayToSort, 0, idexOfFirst);
        secondArray = Arrays.copyOfRange(arrayToSort, idexOfFirst, arrayToSort.length);

        firstArray = getSortedArray(firstArray);
        secondArray = getSortedArray(secondArray);


        return mergeArrays(firstArray, secondArray);
    }

    private int[] mergeArrays(int[] arrayOne, int[] arrayTwo) {
        int lengthOfArray = arrayOne.length + arrayTwo.length;
        int[] mergedArray = new int[lengthOfArray];

        int i = 0;
        int x = 0;
        int m = 0;
        while (m < lengthOfArray) {
            if (i >= arrayOne.length) {
                mergedArray[m] = arrayTwo[x];
                x++;
                m++;
            } else if (x >= arrayTwo.length) {
                mergedArray[m] = arrayOne[i];
                i++;
                m++;
            } else if (arrayOne[i] <= arrayTwo[x]) {
                mergedArray[m] = arrayOne[i];
                i++;
                m++;
            } else if (arrayOne[i] > arrayTwo[x]) {
                mergedArray[m] = arrayTwo[x];
                x++;
                m++;
            }
        }
        return mergedArray;
    }

    @Override
    public String toString() {
        return "Merge Sorter";
    }
}
