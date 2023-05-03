package memoapp;

public class Node<E, F extends Comparable> implements Comparable<Node> {

    E element;
    F key;
    Node left;
    Node right;

    public Node() {
        element = null;
        key = null;
        left = null;
        right = null;
    }

    public Node(E element) {
        this.element = element;
        key = null;
        left = null;
        right = null;
    }
    
    public Node(E element, F key) {
        this.element = element;
        this.key = key;
        left = null;
        right = null;
    }
    
    @Override
    public int compareTo(Node t) {
        return this.key.compareTo(t.key);
    }
}
