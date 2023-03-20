package Type;

public class DoublyLinkedList {
    class Node {
        int item;
        Node previous;
        Node next;

        public Node(int item) {
            this.item = item;
        }
    }

    Node head, tail = null;

    public void addNode(int item) {
        Node newNode = new Node(item);

        if (head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    public void printAllNodes() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of the list: ");
        while (current != null) {
            System.out.println(current.item + " ");
            current = current.next;
        }
    }

    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void addIntoHead(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }
    }
    public int returnHead() {
        return head.item;
    }
}
