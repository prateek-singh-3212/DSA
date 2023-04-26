package Linked_List;

public class Main {
    public static void main(String []args) {
//        // LinkedList using java classes.
//        java.util.LinkedList list = new java.util.LinkedList();
//        list.add(3);
//        list.add("A");
//        System.out.println("Linked List using java classes." + list);
//
//        // Linked List using custom classes.
//        LinkedList customList = new LinkedList();
//        // Add Last element.
//        customList.addLastElement("A");
//        customList.addLastElement("B");
//        customList.addLastElement("C");
//        customList.addLastElement("D");
//        // Add element at first.
//        customList.addFirstElement(0);
//
//        System.out.println("Index of element: " + customList.indexOf("0"));
//        System.out.println("Size of list: " + customList.size());
//
//        customList.iterateList();
//        customList.removeLastElement();
//        customList.iterateList();
////        customList.removeFirstElement();
//        customList.iterateList();
//
//        System.out.println("Element Contains in list: " + customList.contains("D"));
//
        ListNode new1 = new ListNode(1);
        new1.next = new ListNode(2);

        ListNode new2 = new ListNode(3);
        new2.next = new ListNode(4);
        new2.next = new2;
        new2.next = new ListNode(5);

        System.out.println(mergeTwoLists(new1, new2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode newList = new ListNode();
        System.out.println(list1 + " " + list2);

        while(temp1.next != null && temp2.next != null) {
            if(temp1.next == null) {
                return newList.next = temp2;
            }
            if(temp2.next == null) {
                return newList.next = temp1;
            }

            if(temp1.val <= temp2.val) {
                newList.next = new ListNode(temp1.val);
                newList = newList.next;
                temp1 = temp1.next;
            }else {
                newList.next = new ListNode(temp2.val);
                newList = newList.next;
                temp2 = temp2.next;
            }
        }
        return newList;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
