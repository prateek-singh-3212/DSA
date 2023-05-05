package Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HeapsMain {

    public static void main(String[] args) {
        // This class Contains the Implementation of Heaps...
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(6);
        list.add(1);
        list.add(7);
        list.add(1);

        BinaryHeap heap = new BinaryHeap(list);
        heap.printList();
    }
}
