package com.mergesort;

public class MergeSort<E extends Comparable> {

    private E[] arrayOfItems;

    public MergeSort(E[] arrayOfItems) {
        this.arrayOfItems = arrayOfItems;
        mergeSort(this.arrayOfItems);
    }

    public E[] getAll() {
        return this.arrayOfItems;
    }

    private void mergeSort(E[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            E[] leftPartition = sliceArray(array, 0, mid);
            mergeSort(leftPartition);
            E[] rightPartition = sliceArray(array, mid, array.length);
            mergeSort(rightPartition);
            merge(leftPartition, rightPartition, array);
        }
    }

    private E[] sliceArray(E[] array, int start, int end) {
        int size = end - start;
        E[] newArray = (E[]) new Comparable[size];
        for (int i = 0, j = start; i < size; i++, j++) {
            newArray[i] = array[j];
        }
        return (E[]) newArray;
    }

    private void merge(E[] leftPartition, E[] rightPartition, E[] array) {
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        while (index1 < leftPartition.length && index2 < rightPartition.length) {
            if (leftPartition[index1].compareTo(rightPartition[index2]) < 0)
                array[index3++] = leftPartition[index1++];
            else
                array[index3++] = rightPartition[index2++];
        }

        while (index1 < leftPartition.length)
            array[index3++] = leftPartition[index1++];

        while (index2 < rightPartition.length)
            array[index3++] = rightPartition[index2++];
    }

    public static void printArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
