package Sorting;

public class CountingSort {

    private int[] elements;

    public CountingSort(int[] elements) {
        this.elements = elements;
    }

    public int[] countingSort(){
        // Creating array of size == maximum number in array. elements[i]
        int[] numArray = new int[getMaximumNumber(elements)+1];

        // Settings the number in array.
        for (int element : elements) {
            // Incrementing the value in number array.
            numArray[element]++;
        }

        // Sorting the array.
        for (int i=0; i<numArray.length; i++) {
            if (numArray[i] != 0) {
            }
        }

        return elements;
    }

    private int getMaximumNumber(int[] array) {
        int max = -1;
        for (int element: array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

}
