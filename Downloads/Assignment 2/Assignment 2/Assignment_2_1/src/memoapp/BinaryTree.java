package memoapp;

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
        if (newNode.key.compareTo(root.key) < 0) {
            if (root.left == null) {
                root.left = newNode;
                number_of_nodes++;
            } else {
                addNode(root.left, newNode);
            }
        } else {
            if (root.right == null) {
                root.right = newNode;
                number_of_nodes++;
            } else {
                addNode(root.right, newNode);
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
                    node = node.left;
                }
                node = stack.pop();

                // Display the details of the current node
                System.out.println(node.element.toString() + " (Key: " + node.key.toString() + ")");

                node = node.right;
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
            toSortedList(root.left);
            int index = 0;

            // Add the current node to the nodeList array
            nodeList[number_of_nodes - (index++) - 1] = root;

            // Traverse the right subtree
            toSortedList(root.right);
        }
    }

    public E searchElement(F key) {
        Node targetNode = new Node(null, key);
        Node resultNode = searchNode(root, targetNode);

        if (resultNode != null) {
            return (E) resultNode.element;
        } else {
            return null;
        }
    }

// This method provides an efficient way to search for a specific node in the binary search tree based on its key.    
    public Node searchNode(Node root, Node node) {
        if (root == null || node == null) {
            return null;
        }
        if (root.key.compareTo(node.key) == 0) {
            return root;
        } else if (root.key.compareTo(node.key) > 0) {
            return searchNode(root.left, node);
        } else {
            return searchNode(root.right, node);
        }
    }

    public void reverseOrder() {
        traversal(root);
    }

    private void reverseOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        // Traverse the tree in reverse order using an iterative approach
        while (current != null || !stack.isEmpty()) {
            // Traverse the right subtree
            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            // Visit the top node on the stack
            current = stack.pop();
            System.out.println(current.element.toString() + " (Key: " + current.key.toString() + ")");

            // Traverse the left subtree
            current = current.left;
        }
    }

}
