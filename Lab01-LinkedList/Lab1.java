// CS211 - Algorithms & Data Structures
// Lab: Linked List Reversal
// Damian Ciumacenco
// Maynooth University

import java.util.Scanner;

class Link {
    int data;
    Link next;

    Link(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Link first;

    public LinkedList() {
        first = null;
    }

    public void insert(int value) {
        Link newLink = new Link(value);
        if (first == null) {
            first = newLink;
            return;
        }
        Link current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newLink;
    }

    public void display() {
        Link current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }
}

public class Lab1 {

    public static void reverse(LinkedList list) {
        Link prev = null;
        Link current = list.getFirst();
        Link next = null;

        while (current != null) {
            next = current.next;  // Store the next node
            current.next = prev;  // Reverse the link
            prev = current;       // Move prev forward
            current = next;       // Move current forward
        }

        list.setFirst(prev);  // Update the head of the list
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter integers (separated by spaces, ending with 'a')");
        // Input example: "10 20 30 a"
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            list.insert(value);
        }
        scanner.close();

        System.out.print("Original:  ");
        list.display();

        reverse(list);

        System.out.print("Reversed:  ");
        list.display(); // Should output: 30 20 10
    }
}
