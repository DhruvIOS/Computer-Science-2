import java.util.NoSuchElementException;

public abstract class LinkedListIntClass implements LinkedListIntADT {
    protected class Node {
        int info;
        Node next;

        Node(int info) {
            this.info = info;
            this.next = null;
        }
    }

    protected Node head;
    protected int count;

    public LinkedListIntClass() {
        head = null;
        count = 0;
    }

    public boolean isEmptyList() {
        return head == null;
    }

    public void initializeList() {
        head = null;
        count = 0;
    }

    public int length() {
        return count;
    }

    public int front() {
        if (isEmptyList()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.info;
    }

    public int back() {
        if (isEmptyList()) {
            throw new NoSuchElementException("List is empty");
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.info;
    }

    public boolean search(int searchItem) {
        Node current = head;
        while (current != null) {
            if (current.info == searchItem) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void insertFirst(int newItem) {
        Node newNode = new Node(newItem);
        newNode.next = head;
        head = newNode;
        count++;
    }

    public void insertLast(int newItem) {
        Node newNode = new Node(newItem);
        if (isEmptyList()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        count++;
    }

    public void deleteNode(int deleteItem) {
        if (isEmptyList()) {
            System.out.println("List is empty, cannot delete.");
            return;
        }

        if (head.info == deleteItem) {
            head = head.next;
            count--;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.info != deleteItem) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
            count--;
        } else {
            System.out.println("Item not found.");
        }
    }

    public abstract void print(); // To be implemented in subclasses
}