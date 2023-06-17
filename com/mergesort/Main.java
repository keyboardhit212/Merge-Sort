package com.mergesort;

public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort<Integer> list = new MergeSort<>(array);
        MergeSort.printArray(list.getAll());
    }
}

