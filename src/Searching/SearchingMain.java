package Searching;

public class SearchingMain {
    public static void main(String[] args) {
        int[] array1 = new int[]{1,3,5,6,7};

        LinearSearch linearSearch= new LinearSearch(array1);
        int found1= linearSearch.linearSearch(5);
        if (found1 != -1){
            System.out.println("LINEAR SEARCH: element found at index " + found1);
        }else {
            System.out.println("LINEAR SEARCH: Element not found.");
        }

        BinarySearch binarySearch = new BinarySearch(array1);
        binarySearch.binarySearch(0);
    }
}
