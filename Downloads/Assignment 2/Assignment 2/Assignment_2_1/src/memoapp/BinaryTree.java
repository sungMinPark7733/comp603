package memoapp;

import java.util.Date;
import java.util.Stack;

public class BinaryTree<E, F extends Comparable> {

    Node root;
    int number_of_nodes;
    Node[] nodeList;

    public BinaryTree(Node node) {
        root = node;
        number_of_nodes = 1;
        nodeList = new Node[]{node};
    }

    public BinaryTree(E element, F key) {
        Node node = new Node(element, key);
        root = node;
        number_of_nodes = 1;
        nodeList = new Node[]{node};
    }

    public BinaryTree() {
        root = null;
    }

    public void addElement(E element, F key) {
        Node newNode = new Node(element, key);
        addNode(root, newNode);
    }

    //This method adds nodes to the tree in a sorted order based on their keys using the binary search tree insertion algorithm
    public void addNode(Node root, Node newNode) {
        if (this.root == null) {
            this.root = newNode;
            number_of_nodes++;
        }
        if (newNode.getKey().compareTo(root.getKey()) < 0) {
            if (root.getLeft() == null) {
                root.setLeft(newNode);
                number_of_nodes++;
            } else {
                addNode(root.getLeft(), newNode);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(newNode);
                number_of_nodes++;
            } else {
                addNode(root.getRight(), newNode);
            }
        }
    }

    public void traversal(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            Node node = root;

            // Traverse the tree and push the nodes onto the stack
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
                node = stack.pop();

                // Display the details of the current node
                System.out.println(node.getElement().toString() + " (Key: " + node.getKey().toString() + ")");

                node = node.getRight();
            }
        }
    }

    public Node[] toSortedList() {
        // Initialize the nodeList array with the correct size
        nodeList = new Node[number_of_nodes];

        // Fill the nodeList array with the nodes of the tree in sorted order
        toSortedList(root);

        return nodeList;
    }

    private void toSortedList(Node root) {
        if (root != null) {
            // Traverse the left subtree
            toSortedList(root.getLeft());
            int index = 0;

            // Add the current node to the nodeList array
            nodeList[number_of_nodes - (index++) - 1] = root;

            // Traverse the right subtree
            toSortedList(root.getRight());
        }
    }

    public E searchElement(F key) {
        Node targetNode = new Node(null, key);
        Node resultNode = searchNode(root, targetNode);

        if (resultNode != null) {
            return (E) resultNode.getElement();
        } else {
            return null;
        }
    }

// This method provides an efficient way to search for a specific node in the binary search tree based on its key.    
    public Node searchNode(Node root, Node node) {
        if (root == null || node == null) {
            return null;
        }
        if (root.getKey().compareTo(node.getKey()) == 0) {
            return root;
        } else if (root.getKey().compareTo(node.getKey()) > 0) {
            return searchNode(root.getLeft(), node);
        } else {
            return searchNode(root.getRight(), node);
        }
    }

    // method to perform reverse-order traversal of the binary tree
    public void reverseOrder() {
        reverseOrder(root);
    }

    // helper method for reverse-order traversal
    private void reverseOrder(Node node) {
        if (node != null) {
            reverseOrder(node.getRight()); // visit right subtree
            nodeList[number_of_nodes++] = node; // add node to nodeList
            reverseOrder(node.getLeft()); // visit left subtree
        }
    }

    public void insert(Date date, Memo memo) {
        
    }

}
