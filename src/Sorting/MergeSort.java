package Sorting;

import java.util.Arrays;

/**
 * 1. Divide the array into HALF.
 * 2. Sort each HALF.
 * 3. Merge results.
 * */
public class MergeSort {

    private int[] elements;

    public MergeSort(int[] elements) {
        this.elements = elements;
    }

    public int[] mergeSort() {
        sort(elements);
        return elements;
    }

    private void sort(int[] array) {
        // Recursive terminate statement
        if (array.length < 2) {
            return;
        }

       // Divide array into half.
        int middle = getMiddle(array.length);
        int[] leftPart = new int[middle];
        int[] rightPart = new int[array.length - middle];

        for (int leftIndex=0; leftIndex<middle; leftIndex++) {
            leftPart[leftIndex] = array[leftIndex];
        }

        for (int rightIndex=0; rightIndex<middle; rightIndex++) {
            rightPart[rightIndex] = array[middle + rightIndex];
        }

        // Sorting the array. (Breaks array into pieces)
        sort(leftPart);
        sort(rightPart);

        // Merge the Sorted part.
        mergeSortedPart(array, leftPart, rightPart);
    }

    private void mergeSortedPart(int[] resultArray, int[] leftPart, int[] rightPart) {
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        // Checks for both the part i.e left and right.
        while (leftIndex < leftPart.length && rightIndex < rightPart.length) {
            // Check the value is greater or smaller and merge according to that.
            if (leftPart[leftIndex] <= rightPart[rightIndex]) {
                resultArray[resultIndex++] = leftPart[leftIndex++];
            } else {
                resultArray[resultIndex++] = rightPart[rightIndex++];
            }
        }

        // If array of right part is greater than above loop will terminate earlier.
        // so we have to add all the element of right part at the end of result array.
        while (rightIndex < rightPart.length){
            resultArray[resultIndex++] = rightPart[rightIndex++];
        }

        // If array of left part is greater than above loop will terminate earlier.
        // so we have to add all the element of left part at the end of result array.
        while (leftIndex < leftPart.length){
            resultArray[resultIndex++] = rightPart[leftIndex++];
        }
    }

    private int getMiddle(int length){
        return length/2;
    }
}
