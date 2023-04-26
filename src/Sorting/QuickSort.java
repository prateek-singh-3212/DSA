package Sorting;

import java.util.Arrays;

public class QuickSort {

    private int[] elements;
    private int pivot;
    // Consider boundary as end of left partition.
    private int leftBoundary = -1;

    public QuickSort(int[] elements) {
        this.elements = elements;
    }

    public int[] quickSort() {
        // initially left boundary is -1 i.e. not available.
        sort(elements, -1);
        return elements;
    }

    private void sort(int[] array, int leftBoundary) {
        // Recursion exit condition.
        if (array.length < 2) {
            return;
        }

        // Select the last item as pivot.
        int pivot = array[array.length - 1];
        // Move the rest elements according to the pivot.
        // continue ->
        for (int indexer = 0; indexer<array.length; indexer++) {
            if (array[indexer] <= pivot) {
                leftBoundary++; // We found 1 element greater than pivot hence increase the left boundary first.
                swap(array, indexer, leftBoundary);
            }
        }
        int[] leftArray = new int[leftBoundary];
        int[] rightArray = new int[array.length - (leftBoundary+1)];

        // Copying the left array.
        for (int i=0; i<leftBoundary; i++) {
            leftArray[i] = array[i];
        }
        // Copying the right array.
        for (int i=0; i<array.length - (leftBoundary+1); i++) {
            rightArray[i] = array[leftBoundary + 1 +i];
        }

        sort(leftArray, -1);
        sort(rightArray, -1);
    }

    /**
     * Swaps the value in array.
     * */
    private void swap(int[] array, int initial, int after) {
        int temp = array[initial];
        array[initial] = array[after];
        array[after] = temp;
    }
}
