package com.sparta.mjn.sorters;

import com.sparta.mjn.search.BinarySearchTree;
import com.sparta.mjn.search.BinaryTree;
import com.sparta.mjn.sorters.Sorter;

public class BinaryTreeSorter implements Sorter {

    @Override
    public int[] getSortedArray(int[] arrayToSort) {
        BinaryTree rootNode = new BinarySearchTree(arrayToSort);

        return rootNode.getSortedTreeAsc();
    }

    @Override
    public String toString() {
        return "BinaryTree  Sorter";
    }
}
