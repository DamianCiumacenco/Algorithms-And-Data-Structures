// CS211 - Algorithms & Data Structures
// Lab 3: Minimum Depth of Binary Tree
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
        root = addRecursive(root, data);
    }

    private Node addRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        if (data < current.data) {
            current.leftChild = addRecursive(current.leftChild, data);
        } else if (data > current.data) {
            current.rightChild = addRecursive(current.rightChild, data);
        }
        return current;
    }

    public int minDepth(Node root) {
        // Base case: empty tree
        if (root == null) {
            return 0;
        }

        // Leaf node — no children
        if (root.leftChild == null && root.rightChild == null) {
            return 1;
        }

        // Only right subtree exists — can't go left
        if (root.leftChild == null) {
            return minDepth(root.rightChild) + 1;
        }

        // Only left subtree exists — can't go right
        if (root.rightChild == null) {
            return minDepth(root.leftChild) + 1;
        }

        // Both subtrees exist — take the shorter path
        return Math.min(minDepth(root.leftChild), minDepth(root.rightChild)) + 1;
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

        int depth = tree.minDepth(tree.root);
        System.out.println("Minimum Depth of Binary Tree is " + depth);
    }
}
