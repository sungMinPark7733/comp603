package memoapp;

public class Node<E, F extends Comparable> implements Comparable<Node> {

    E element;
    F key;
    Node left;
    Node right;

    public Node() {
        this.element = null;
        this.key = null;
        this.left = null;
        this.right = null;
    }

    public Node(E element) {
        this.element = element;
        this.key = null;
        this.left = null;
        this.right = null;
    }

    public int compareTo(Node node) {
        
    }

    @Override
    public int compareTo(Node t) {

    }
}
