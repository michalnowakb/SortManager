package com.sparta.mjn;

import static org.junit.Assert.*;

import com.sparta.mjn.sorters.BubbleSorter;
import com.sparta.mjn.sorters.MergeSorter;
import com.sparta.mjn.sorters.Sorter;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */

//create instance of BubbleSorter
//create array to test
//run sort array method
//compare output is as expected
public class SortTest {
    private Sorter sorter;
    private int[] arrayToSort;
    private int[] arrayAlreadySorted;

    @Before
    public void setup() {
        sorter = new MergeSorter();
        arrayToSort = new int[]{34,90,5,2,56,21,12,8};
        arrayAlreadySorted = new int[]{2,5,8,12,21,34,56,90};
    }

    @Test
    public void testArraySorted() {
        int[] sortedArray = sorter.getSortedArray(arrayToSort);

        for (int i = 0; i < arrayToSort.length - 1; i++) {
            assertTrue(sortedArray[i] <= sortedArray[i + 1]);

        }
    }
    @Test
    public void testNullArray(){
        assertTrue(arrayToSort != null);
    }
    @Test
    public void testSizeArray(){
        int[] sortedArray = sorter.getSortedArray(arrayToSort);

        assertTrue(arrayToSort.length == sortedArray.length);
    }
    @Test
    public void anotherTestArraySorted(){
        int[] sortedArray = sorter.getSortedArray(arrayToSort);

        for (int i = 0; i < arrayToSort.length - 1; i++){
            assertTrue(sortedArray[i] == arrayAlreadySorted[i]);
        }
    }
}
