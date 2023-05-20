package memoapp;

import java.util.Stack;

public class BinaryTree<E, F extends Comparable> {

    Node root;
    int number_of_nodes;
    Node[] nodeList;

    public static void main(String[] args) {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();

        // Adding elements to the tree
        tree.addElement(5, 5);
        tree.addElement(3, 3);
        tree.addElement(7, 7);
        tree.addElement(1, 1);
        tree.addElement(4, 4);

        // Printing the elements in sorted order
        tree.traversal(tree.root);

        Node[] sortedList = tree.toSortedList();
        System.out.println("Sorted List:");
        for (Node node : sortedList) {
            System.out.println(node.getElement().toString() + " (Key: " + node.getKey().toString() + ")");
        }
        System.out.println("Reverse Order:");
        tree.reverseOrder();
        for (Node node : tree.nodeList) {
            System.out.println(node.getElement().toString() + " (Key: " + node.getKey().toString() + ")");
        }

    }

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
        number_of_nodes = 1;
        nodeList = new Node[]{root};
    }

    public BinaryTree(E element, F key) {
        Node node = new Node(element, key);
        root = node;
        number_of_nodes = 1;
        nodeList = new Node[]{node};
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
        } else if (newNode.getKey().compareTo(root.getKey()) < 0) {
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

            // Add the current node to the nodeList array
            nodeList[number_of_nodes - 1] = root;
            number_of_nodes--;

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

}
