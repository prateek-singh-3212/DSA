package Sorting;

public class BubbleSort {

    private int[] elements; // Array of Elements
    private boolean requireNextPass = true; // Checks that sorting requires next pass or not
    private int temp = 0; // Used for swaping the numbers
    private boolean doneSwaping = false; // Tells whether swaping is done or not.

    public BubbleSort(int[] elements) {
        this.elements = elements;
    }

    /**
     * Sorting of int array using BUBBLE SORT in ASCENDING ORDER.
     * @return sorted integer array.
     * */
    public int[] bubbleSort() {

        // We dont know the number of passes require to sort array so we used while loop.
        // However we do know the maximum possible swaping passes is equal to length of array.
        while (requireNextPass) {

            // Checks and swaps the next 2 element inside array.
            for(int i=0; i<(elements.length-1) ; i++) {
                if (elements[i] > elements[i+1]) {
                    temp = elements[i];
                    elements[i] = elements[i+1];
                    elements[i+1] = temp;
                    doneSwaping = true;
                }
            }

            // If the swaping is done then it will exit the while loop.
            if (!doneSwaping) {
                break;
            }
            doneSwaping = false;
        }

        return elements;
    }
}