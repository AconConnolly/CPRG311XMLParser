package Type;

public class DoublyLinkedList {
    public class Node {
       public int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node head;
    public Node tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    /*
    This method inserts a new node at the end of the list. If empty, it will create a new node and ake the head and tail node.
    If the list is not empty, it creates a previous node and sets its previous node to the tail node, and the tails next node to current node.
    */
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    /*
    Deletes the last node of the list. If the list is empty, it will return null. If only one node, both head and tail will be set to null.
    IF more than one, it will delete the tail node and update the tail pointer to the previous node, and sets the previous node's pointer to null.
     */
    public Node deleteFromEnd() {
        if (head == null) {
            return null;
        } else if (head == tail) {
            Node temp = head;
            head = null;
            tail = null;
            size--;
            return temp;
        } else {
            Node temp = tail;
            tail = tail.previous;
            tail.next = null;
            size--;
            return temp;
        }
    }
    /*
    Method traverses the list from the head node and prints the data of each node.
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public void addNode(int data) {
        Node newNode = new Node(data);

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

    public int size() {
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
    public void clear() {
        Node current = tail;
        while (current != null) {
            current = tail.previous;
            deleteFromEnd();
        }
    }


}




