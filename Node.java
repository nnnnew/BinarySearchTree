/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nnnnew
 */
public class Node {
    
    private int element;
    private Node left;
    private Node right;
    
    public Node(int element, Node left, Node right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
    
    public Node(int element) {
        this(element, null, null);
    }
    
    public boolean isLeafNode() {
        if(getLeft() == null && getRight() == null) {
            return true;
        }
        return false;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
