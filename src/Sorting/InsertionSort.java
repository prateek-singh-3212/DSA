package Sorting;

public class InsertionSort {

    private int[] elements;
    private int currentElement = 0;

    public InsertionSort(int[] elements){
        this.elements = elements;
    }

    public int[] insertionSort() {
        for (int index=1; index<elements.length; index++) {
            currentElement = elements[index];
            int j = index-1;
            while (j >=0 && elements[j] > currentElement) {
                elements[j+1] = elements[j];
                j--;
            }
            elements[j+1] = currentElement;
        }
        return elements;
    }
}
