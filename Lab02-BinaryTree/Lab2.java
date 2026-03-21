// CS211 - Algorithms & Data Structures
// Lab: Binary Search Tree
// Damian Ciumacenco
// Maynooth University

import java.util.Scanner;

class Node {
    int data;
    Node leftChild, rightChild;

    Node(int data) {
        this.data = data;
        leftChild = rightChild = null;
    }
}

public class BinaryTree {
    Node root;

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent;

        while (true) {
            parent = current;
            if (data < current.data) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    return;
                }
            }
        }
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight  = getHeight(node.leftChild);
        int rightHeight = getHeight(node.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void traverseInorder(Node localRoot) {
        if (localRoot != null) {
            traverseInorder(localRoot.leftChild);
            System.out.print(localRoot.data + " ");
            traverseInorder(localRoot.rightChild);
        }
    }

    public void traversePreorder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            traversePreorder(localRoot.leftChild);
            traversePreorder(localRoot.rightChild);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter integers to build the tree (end with a non-integer):");
        while (sc.hasNextInt()) {
            int data = sc.nextInt();
            tree.addNode(data);
        }
        sc.close();

        int height = tree.getHeight(tree.root);
        System.out.println("The height of the binary tree is: " + height);

        System.out.println("Inorder traversal of the binary tree:");
        tree.traverseInorder(tree.root);
        System.out.println();

        System.out.println("Preorder traversal of the binary tree:");
        tree.traversePreorder(tree.root);
        System.out.println();
    }
}
