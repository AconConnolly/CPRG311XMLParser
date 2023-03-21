package Type;

import ADTs.ListADT;

import java.util.Iterator;

public class DoublyLinkedList <T> implements ListADT, Iterator {
    public static class Node<T> {
        private T data;
        private Node <T> previous;
        private Node <T> next;

        public Node(T data) {
            this.data = data;
        }
        public Node() {
        }

        public T getData() {
            return data;
        }
    }

    public Node<T> head;
    public Node<T> tail;
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
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    public void insertAtFront(T data) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;
        if (head == null) {
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    /*
    Deletes the last node of the list. If the list is empty, it will return null. If only one node, both head and tail will be set to null.
    IF more than one, it will delete the tail node and update the tail pointer to the previous node, and sets the previous node's pointer to null.
     */
    public Node<T> deleteFromEnd() {
        if (tail == null) {
            return null;
        } else {
            Node<T> deletedNode = tail;

            if (tail.previous == null) { // Only one element in the list
                head = null;
                tail = null;
            } else {
                tail = tail.previous;
                tail.next = null;
            }

            size--;
            return deletedNode;
        }
    }
    public Node<T> deleteFromFront() {
        if (head == null) {
            return null;
        } else {
            Node<T> deletedNode = head;

            if (head.next == null) { // Only one element in the list
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.previous = null;
            }

            size--;
            return deletedNode;
        }
    }

    /*
    Method traverses the list from the head node and prints the data of each node.
     */
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public void clear() {
        Node<T> current = tail;
        while (current != null) {
            current = tail.previous;
            deleteFromEnd();
        }
    }

    @Override
    public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
        return false;
    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
    @Override
    public boolean add(Object toAdd) throws NullPointerException {
        return false;
    }

    @Override
    public boolean addAll(ListADT toAdd) throws NullPointerException {
        return false;
    }

    public void addAll(DoublyLinkedList<T> otherList) {
        Node<T> currentNode = otherList.head;
        while (currentNode != null) {
            insertAtEnd(currentNode.getData());
            currentNode = currentNode.next;
        }
    }

    @Override
    public T get(int index) {
        if (head == null) {
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current.data;
    }

    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Object remove(Object toRemove) throws NullPointerException {
        return null;
    }

    @Override
    public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object toFind) throws NullPointerException {
        return false;
    }

    @Override
    public Object[] toArray(Object[] toHold) throws NullPointerException {
        return new Object[0];
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size];
        Node<T> current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public Object[] toArrayAll() {
        return new Object[0];
    }


    @Override
    public Iterator iterator() {
        return null;
    }
}




