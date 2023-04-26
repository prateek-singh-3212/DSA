package Linked_List;

public class LinkedList {

    // Node is always private because user is not dealing with node.This is
    // Implementation detail.
    private class Node {
        Object data; // Stores the data in NODE.
        Node nextNode; // Stores the reference of next node.
    }

    private Node first = null; // referenced as HEAD
    private Node last = null; // referenced as TAIL

    /**
     * Adds the element in to the end of linked list.
     */
    public void addLastElement(Object data) {
        Node newNode = new Node();

        if (first == null) { // If there is no element in the list.
            newNode.data = data; // Set Data
            newNode.nextNode = null; // Set memory address of next node
            // point first and head to same new node.
            last = newNode;
            first = newNode;
        } else {
            newNode.data = data; // Set data.
            last.nextNode = newNode; // Set last node next to new Node.
            last = newNode; // Set last to new node.
        }
    }

    /**
     * Add the element to beginning of linked list.
     */
    public void addFirstElement(Object data) {
        Node newNode = new Node();

        if (first == null) {
            newNode.data = data; // Set Data
            newNode.nextNode = null; // Set memory address of next node
            // point first and head to same new node.
            last = first = newNode;
        } else {
            newNode.data = data;
            newNode.nextNode = first;
            first = newNode;
        }
    }

    /**
     * Index of Object in linked list.
     *
     * @return -1 if Element not found.
     * else index of element.
     */
    public int indexOf(Object data) {
        int size = 0;
        Node tempNode = first;

        while (tempNode != null) {
            if (tempNode.data.equals(data)) {
                return size;
            }
            size++;
            tempNode = tempNode.nextNode;
        }
        return -1; // unable to find element returning -1.
    }

    /**
     * Size of Linked List.
     */
    public int size() {
        int size = 0;
        Node tempNode = first;

        while (true) {
            size++;
            if (tempNode.nextNode == null) {
                break;
            } else {
                tempNode = tempNode.nextNode;
            }
        }
        return size;
    }

    /**
     * Iterates all the elements of Linked List.
     */
    public void iterateList() {
        Node tempNode = first;
        System.out.println("... Iterating list STARTS ...");

        while (tempNode != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.nextNode; // Setting temp node to next node.
        }
        System.out.println("... Iterating list ENDS ...");
    }

    /**
     * Checks that linked list contains the object or not.
     */
    public boolean contains(Object element) {
        Node tempNode = first;

        while (tempNode != null) {
            if (tempNode.data == element) {
                return true;
            }
            tempNode = tempNode.nextNode; // Setting temp node to next node.
        }
        return false;
    }

    public void removeLastElement() {
        Node tempNode = first;
        while (tempNode != null) {


//            public void removeFirstElement () {
//                first = first.nextNode; // replacing head/first to second node address.
//                first.nextNode = null; // removes the link between first and second node.
//            }

//    public void reverse() {
//        while ( != null)
//    }
        }
    }
}