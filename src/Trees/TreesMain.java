package Trees;

public class TreesMain {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertData(20);
        binaryTree.insertData(10);
        binaryTree.insertData(6);
        binaryTree.insertData(14);
        binaryTree.insertData(3);
        binaryTree.insertData(8);
        binaryTree.insertData(30);
        binaryTree.insertData(24);
        binaryTree.insertData(26);
        System.out.println("INSERTION DONE");

        // Find in tree.
        if (binaryTree.find(2) == 1) {
            System.out.println("Data Found");
        } else {
            System.out.println("Data not found");
        }
        if (binaryTree.find(10) == 1) {
            System.out.println("Data Found");
        } else {
            System.out.println("Data not found");
        }

        // Traversing. TODO: Breadth traversing. ALGO:
        System.out.println("DEPTH PRE-ORDER TRAVERSAL" + binaryTree.depthPreOrderTraverse());
        System.out.println("DEPTH IN-ORDER TRAVERSAL" + binaryTree.depthInOrderTraversal());
        System.out.println("DEPTH POST-ORDER TRAVERSAL" + binaryTree.depthPostOrderTraversal());

        // Height  of tree.
        System.out.println("HEIGHT: " + binaryTree.height());

        // Minimum of tree.
        System.out.println("MINIMUM: "+ binaryTree.minimum());
    }
}
