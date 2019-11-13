package com.sparta.mjn.sorters;

public class QuickSorter implements Sorter {

    @Override
    public int[] getSortedArray(int[] arrayToSort) {
        if(arrayToSort.length <= 1){
            return arrayToSort;
        }
        int pivot = arrayToSort[arrayToSort.length-1];
        int leftsize = 0;
        int rightsize = 0;
        int left =0 ;
        int right = 0;


        int[] sortedArray = new int[arrayToSort.length];
        int indexOfSortedArray = 0;

        for(int i = 0; i < arrayToSort.length -1; i++) {

            if (pivot >= arrayToSort[i]) {
                leftsize++;

            } else if (pivot < arrayToSort[i]) {
                rightsize++;
            }
        }

            int[] smallerArray = new int[leftsize];
            int[] biggerArray = new int[rightsize];

            for(int j = 0; j < arrayToSort.length - 1; j++ ){
                if (pivot >= arrayToSort[j]) {
                    smallerArray[left++] = arrayToSort[j];
                }
                else if (pivot < arrayToSort[j]) {
                    biggerArray[right++] = arrayToSort[j];
                }
            }

            smallerArray = getSortedArray(smallerArray);
            biggerArray = getSortedArray(biggerArray);


        for (int j : smallerArray) {
            sortedArray[indexOfSortedArray++] = j;
        }

        sortedArray[indexOfSortedArray++] = pivot;

        for (int j : biggerArray){
            sortedArray[indexOfSortedArray++] = j;
        }


        return sortedArray;
    }

    @Override
    public String toString() {
        return "Quick Sorter";
    }
}
