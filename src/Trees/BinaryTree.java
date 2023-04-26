package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node rootNode;
    private List<Integer> tree = new ArrayList<>();
    private List<Integer> inOrderTree = new ArrayList<>();
    private List<Integer> postOrderTree = new ArrayList<>();
    private int minimum = -1;



    public int minimum() {
        return minimum(rootNode);
    }

    // O(n)Time Complexity
    public int minimum(Node node) {
        if (node == null) { // Condition for checking leaf node.
            return Integer.MAX_VALUE;
        }
        return Math.min(Math.min(minimum(node.leftNode), minimum(node.rightNode)), node.data);
    }

    public int height() {
        return height(rootNode);
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.leftNode), height(node.rightNode));
    }

    public List<Integer> depthPostOrderTraversal() {
        return depthPostOrderTraversal(rootNode);
    }

    public List<Integer> depthPostOrderTraversal(Node node) {
        if (node == null) {
            return postOrderTree;
        }
        depthPostOrderTraversal(node.leftNode);
        depthPostOrderTraversal(node.rightNode);
        postOrderTree.add(node.data);
        return postOrderTree;
    }

    public List<Integer> depthInOrderTraversal() {
        return depthInOrderTraversal(rootNode);
    }

    public List<Integer> depthInOrderTraversal(Node node) {
        if (node == null) {
            return inOrderTree;
        }
        depthInOrderTraversal(node.leftNode);
        inOrderTree.add(node.data);
        depthInOrderTraversal(node.rightNode);
        return inOrderTree;
    }

    public List<Integer> depthPreOrderTraverse() {
        return depthPreOrderTraverse(rootNode);
    }

    private List<Integer> depthPreOrderTraverse(Node node) {
        if (node == null) {
            return tree;
        }
        tree.add(node.data);
        depthPreOrderTraverse(node.leftNode);
        depthPreOrderTraverse(node.rightNode);
        return tree;
    }

    public int find(int data) {
        if (rootNode == null) {
            return -1; // Create the tree first.
        }
        Node currentNode = rootNode; // Start from Top
        while (true) {
            if (data == currentNode.data) {
                return +1;
            }
            if (data < currentNode.data) {
                // Go to left side of Node.
                if (currentNode.leftNode != null) {
                    if (currentNode.leftNode.data == data) {
                        return 1; // Item Found
                    } else {
                        currentNode = currentNode.leftNode;
                    }
                } else {
                    return -1; // Item Not found
                }
            } else {
                // Go to right side of Node.
                if (currentNode.rightNode != null) {
                    if (currentNode.rightNode.data == data) {
                        return 1; // Item Found
                    } else {
                        currentNode = currentNode.rightNode;
                    }
                } else {
                    return -1; // Item Not found
                }
            }
        }
    }

    public void insertData(int data) {
        Node node = new Node(data);

        if (rootNode == null) {
            rootNode = node;
            return; // Sets the root node and exit the program.
        }

        // Sets the currentNode to rootNode
        // because we have to start from root of Tree whenever we insert data in list.
        Node currentNode = rootNode;

        while (true) {
            // TODO: IMPLEMENTING THE BINARY TREE IN THE INSERTING OF DATA.
            // Only set the data when left or right node is null
            // in the tree else go 1 step down in the tree.
            if (data < currentNode.data) {
                // Insert data to the left side of NODE.
                if (currentNode.leftNode == null) {
                    currentNode.leftNode = node;
                    return;
                }
                // If left node is not null then set the current node to currentNode.leftNode.
                // THIS WILL CONTINUE THE LOOP.
                currentNode = currentNode.leftNode;
            }else {
                // Insert data to the right side of NODE.
                if (currentNode.rightNode == null) {
                    currentNode.rightNode = node;
                    return;
                }
                // If left node is not null then set the current node to currentNode.rightNode.
                // THIS WILL CONTINUE THE LOOP.
                currentNode = currentNode.rightNode;
            }
        }
    }

    private class Node {
        private int data;
        private Node leftNode;
        private Node rightNode;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node -> " + data;
        }
    }
}
