package memoapp;

public class Node<E, F extends Comparable> implements Comparable<Node> {

    private E element;
    private F key;
    private Node left;
    private Node right;

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
        return this.getKey().compareTo(t.getKey());
    }

    /**
     * @return the element
     */
    public E getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * @return the key
     */
    public F getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(F key) {
        this.key = key;
    }

    /**
     * @return the left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Node getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Node right) {
        this.right = right;
    }
}
