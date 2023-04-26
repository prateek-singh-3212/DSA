package Searching;

public class BinarySearch {

    private int[] array;
    private int leftPointer;
    private int rightPointer;

    public BinarySearch(int[] array) {
        this.array = array;
        leftPointer = 0;
        rightPointer = array.length-1;
    }

    public int binarySearch(int find) {
        int middle = (leftPointer + rightPointer)/2;

        if (leftPointer > rightPointer) {
            System.out.println("BINARY SEARCH: Element not found.");
            return -1;
        }

        if (array[middle] == find) {
            System.out.println("BINARY SEARCH: element found at index " + middle);
            return (middle+1);
        }

        if (array[middle] > find) {
            // Our element is in left part.
            leftPointer = 0;
            rightPointer = middle-1;
            return binarySearch(find);
        }

        // If less than element the element we have to find.
        leftPointer = middle+1;
        rightPointer = array.length-1;
        return binarySearch(find);
    }
}
