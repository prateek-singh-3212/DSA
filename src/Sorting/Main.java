package Sorting;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {
        int[] array1 = new int[]{8,2,4,4,1,3};
        int[] array2 = new int[]{8,2,4,4,1,3};
        int[] array3 = new int[]{8,2,4,4,1,3};
        int[] array4 = new int[]{8,2,4,4,1,3};
        int[] array5 = new int[]{8,2,4,4,1,3};

        BubbleSort bubbleSort = new BubbleSort(array1);
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSort.bubbleSort()));

        SelectionSort selectionSort = new SelectionSort(array2);
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort.selectionSort()));

        InsertionSort insertionSort = new InsertionSort(array3);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSort.insertionSort()));

        MergeSort mergeSort = new MergeSort(array4);
        System.out.println("Merge Sort: " + Arrays.toString(mergeSort.mergeSort()));

        QuickSort quickSort = new QuickSort(array5);
        System.out.println("Quick Sort: " + Arrays.toString(quickSort.quickSort()));
    }
}
