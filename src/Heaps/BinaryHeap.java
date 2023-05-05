package Heaps;

import java.util.*;

public class BinaryHeap {

    List<Integer> list;

    public BinaryHeap() {
        list = new ArrayList<>();
    }

    public BinaryHeap(List<Integer> list) {
        this.list = list;
        arrange();
    }

    public void add(int num) {
        list.add(num);
        int currIndex = list.size()-1;
        int parentIndex = parentIndex(currIndex);
        while (list.get(parentIndex) > list.get(currIndex)) {
            Collections.swap(list, currIndex, parentIndex);
        }
    }

    public void arrange() {
        heapify(list.size()/2);
    }

    /**
     * It arranges only the nodes below it...
     * */
    private void heapify(int currIndex) {
        System.out.println("heapify: " + currIndex);
        // Recursion...
        // Base Condition...
        if(currIndex <= 0 || currIndex > list.size()) {
            // index is not present...
            return;
        }

        int left = leftChildIndex(currIndex);
        int right = rightChildIndex(currIndex);

        if(list.size() > left && list.get(left) < list.get(currIndex)) {
            // Swap...
            Collections.swap(list, left, currIndex);
            heapify(left);
        }

        if(list.size() > right && list.get(right) < list.get(currIndex)) {
            // Swap...
            Collections.swap(list, right, currIndex);
            heapify(right);
        }

//        heapify(currIndex-1);
    }

    private void heapify() {
        // To heapify the array we have to iterate of all the non leaf nodes...
        heapify(list.size()/2);
    }

    public void printList() {
        printList("");
    }

    public void printList(String str) {
        System.out.println(str + " " + Arrays.toString(list.toArray()));
    }

    private int rightChildIndex(int i) {
        return 2*i+2;
    }

    private int leftChildIndex(int i) {
        return 2*i+1;
    }

    private int parentIndex(int i) {
        return (i-1)/2;
    }
}
