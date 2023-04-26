package Searching;

public class LinearSearch {

    private int[] array;

    public LinearSearch(int[] array) {
        this.array = array;
    }

    public int linearSearch(int find) {
        for (int index=0; index<=array.length; index++) {
            if (array[index] == find) {
                return index+1;
            }
        }
        return -1;
    }
}
