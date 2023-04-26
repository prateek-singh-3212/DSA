package Sorting;

public class SelectionSort {

    private int[] elements; // Integer array which is to be sorted.
    private int lastIndexSoredArray = 0; // Last index of element in sorted part of array.
    private int lowestNumber = 0; // Stores the lowest number in array.

    public SelectionSort(int[] elements) {
        this.elements = elements;
    }

    /**
     * Sorting of int array using SELECTION SORT in ASCENDING ORDER.
     * @return sorted integer array.
     * */
    public int[] selectionSort() {
        lowestNumber = elements[0];
        for (int i=0; i<elements.length; i++) {
            if (lowestNumber > elements[i]) {
                lowestNumber = elements[i]; // Making the lowest number equals to first element of unsorted array.
                swap(elements, i, lastIndexSoredArray);
                lastIndexSoredArray++; // Incrementing the last index of sorted array.
            }
        }
        return elements;
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
