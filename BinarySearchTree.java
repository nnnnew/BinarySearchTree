/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nnnnew
 */
public class BinarySearchTree {

    private Node root;

    public void addElement(int number) {
        if (root == null) {
            root = new Node(number);
        } else {
            Node travNode = root;
            Node tempNode = null;
            while (travNode != null) {
                if (number < travNode.getElement()) {
                    tempNode = travNode;
                    travNode = travNode.getLeft();
                } else if (number > travNode.getElement()) {
                    tempNode = travNode;
                    travNode = travNode.getRight();
                } else {
                    System.out.println(number + " is duplicate");
                    return;
                }
            }
            Node newNode = new Node(number);
            if (number < tempNode.getElement()) {
                tempNode.setLeft(newNode);
            } else {
                tempNode.setRight(newNode);
            }
        }
    }

    public void removeNode(int number) {
        if(root == null) {
            System.out.println("No tree");
        }
        else if(!findNumber(number)) {
            System.out.println("No " + number +" in tree");
        }
        else {
            root = removeNode(number, root);
        }
    }

    private Node removeNode(int number, Node node) {
        if (node == null) {
            return node;
        }
        if (number < node.getElement()) {
            node.setLeft(removeNode(number, node.getLeft()));
        } else if (number > node.getElement()) {
            node.setRight(removeNode(number, node.getRight()));
        } else if (node.getLeft() == null || node.getRight() == null) {
            if (node.getLeft() == null) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
        } else {
            Node tempNode = node.getRight();
            while (tempNode.getLeft() != null) {
                tempNode = tempNode.getLeft();
            }
            node.setElement(tempNode.getElement());
            node.setRight(removeNode(tempNode.getElement(), node.getRight()));
        }
        return node;
    }

    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    public boolean findNumber(int number) {
        Node travNode = root;
        while (travNode != null) {
            if (number < travNode.getElement()) {
                travNode = travNode.getLeft();
            } else if (number > travNode.getElement()) {
                travNode = travNode.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    public Node getRoot() {
        return this.root;
    }

    public void printTree(Node node, int level) {
        if (node == null) {
            return;
        }
        printTree(node.getRight(), level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("\t");
            }
            System.out.println("|-------" + node.getElement());
        } else {
            System.out.println(node.getElement());
        }
        printTree(node.getLeft(), level + 1);
    }

}
