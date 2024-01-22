package GitHub.LinkedLists;

import java.util.HashSet;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;

    void insert(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        else{
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void removeDuplicate(){
        HashSet<Integer> uniqueSet = new HashSet<Integer>();
        Node currentNode = head;
        Node prevNode = null;

        while (currentNode != null) {
            if (uniqueSet.contains(currentNode.data)) {
                prevNode.next = currentNode.next;
            } else {
                uniqueSet.add(currentNode.data);
                prevNode = currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    void display(){
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class removeDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the List:");
        int N = scanner.nextInt();

        System.out.println("Enter the Unique Picture IDs with spaces");
        LinkedList list = new LinkedList();
        for (int i = 0; i < N; i++) {
            int picId = scanner.nextInt();
            list.insert(picId);
        }

        System.out.println("List before removal");
        list.display();
        System.out.println("List after removal");
        list.removeDuplicate();
        list.display();

        scanner.close();
    }
}
