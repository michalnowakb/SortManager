package com.sparta.mjn.sorters;

public class BubbleSorter implements Sorter {
    private int length;
    private int number;

    public int[] getSortedArray(int[] arrayToSort) {
        boolean swapedNumber = false;
        do {
            swapedNumber = false;
            for (int i = 0; i < arrayToSort.length - 1; i++) {
                if (arrayToSort[i] > arrayToSort[i + 1]) {
                    int tempNumber = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = tempNumber;
                    swapedNumber = true;
                }
            }
        } while (swapedNumber);
        return arrayToSort;
    }

    @Override
    public String toString() {
        return "Bubble Sorter";
    }
}
