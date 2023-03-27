package types;

import utilities.Iterator;
import utilities.ListADT;

import java.util.NoSuchElementException;

/**
* Method that adds every value in holder to the top of the stack
*
* @author Alex
*/
public class MyDLL <T> implements ListADT, Iterator {
    public static class Node<T> {
        T data;
        Node <T> previous;
        Node <T> next;

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

    public MyDLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }



    /*
    This method inserts a new node at the end of the list. If empty, it will create a new node and ake the head and tail node.
    If the list is not empty, it creates a previous node and sets its previous node to the tail node, and the tails next node to current node.
    */
    /**
    * Method that adds a new node value in the end of the list
    *
    * @param data The value of the data being added to the list
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

    /**
    * Method that adds a new node value in the start of the list
    *
    * @param data The value of the data being added to the list
    */
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
    /**
    * Method that deletes the data at the end of the list
    *
    * @return The data being deleted in the list
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
    
    /**
    * Method that deletes the data at the beginning of the list
    *
    * @return The data being deleted in the list
    */
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
    /**
    * Method that prints every node in the list
    */
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
	 * Method to return the length of the list
	 * 
	 * @return The length of the stack
	 */
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

    //Specific location in the list
    /**
    * Method that adds a new node at a specific index
    *
    * @param index The position of where the new node will be added
    * @param data The data inside the new node
    * @return true if the new  node has been  added
    * @exception NullPointerException If the data is null
    * @exception IndexOutOfBoundsException If the index is out of bounds in the list
    */
    @Override
    public boolean add(int index, Object data) throws NullPointerException, IndexOutOfBoundsException {
        if (data == null) {
            throw new NullPointerException("Cannot add null element to the list.");
        }
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node<T> newNode = new Node<T>((T) data);
        if (index == 0) {
            // Insert at the front of the list
            insertAtFront((T) data);
        } else if (index == size()) {
            // Insert at the end of the list
            insertAtEnd((T) data);
        } else {
            // Insert at the specified index
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next.previous = newNode;
            current.next = newNode;
            newNode.previous = current;
            size++;
        }
        return true;
    }

    /**
    * Method that checks if head of the list is null
    * 
    * @return true If the head is not null
    */
    @Override
    public boolean hasNext() {
        return head != null;
    }

// I dunno how to explain this
    /**
    * Method that checks if there is another object in the list
    * 
    * @return
    */
    @Override
    public Object next() {
        return null;
    }

    //At the end
    /**
    * Method that adds every value in holder to the top of the stack
    *
    * @param holder An array that holds all the object to be added
    * @return The array containing the stack values in order
    * @exceptions NullPointerException If the toAdd is null
    */
    @Override
    public boolean add(Object toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null to the list.");
        }
        Node<T> newNode = new Node<T>((T) toAdd);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;

        return true;
    }

// I dunno how to explain this
    /**
    * Method that
    *
    * @param toAdd
    * @return 
    * @exceptions NullPointerException If toAdd is null
    */
    @Override
    public boolean addAll(ListADT toAdd) throws NullPointerException {
        return false;
    }

// I dunno how to explain this
    /**
    * Method that
    *
    * @param otherList
    */
    public void addAll(MyDLL<T> otherList) {
        Node<T> currentNode = otherList.head;
        while (currentNode != null) {
            insertAtEnd(currentNode.getData());
            currentNode = currentNode.next;
        }
    }

    /**
    * Method to get the data of a node at a specific index
    *
    * @param index The position in the list
    * @return The value of the specificied node
    */
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

    //Remove at specific index
    /**
    * Method to look for a node with an index and remove it from the list
    *
    * @param index The position in the list
    * @return The value of the deleted node
    * @exceptions IndexOutOfBoundsException If index is out of bounds
    */
    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        if (head == null) {
            return null;
        }
        if (index == 0) {
            T dataRemove = head.data;
            head = head.next;
            return dataRemove;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        T dataRemove = current.data;
        if(size != 2) {
        	current.next = current.next.next;
        }
        size--;
        return dataRemove;
    }

    //Search for and remove an object
    /**
    * Method to look for a node with an object value and remove it from the list
    *
    * @param toRemove The value of the object being removed
    * @return The value of the deleted node
    * @exceptions NullPointerException If toRemove is null
    */
    @Override
    public Object remove(Object toRemove) throws NullPointerException {
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

    /**
    * Method that replaces the data inside a node at a specfic index
    *
    * @param index The position of the list being replaced
    * @param toChange The new value of the object replacing the old object
    * @return The value of the object being replaced
    * @exceptions NullPointerException If toChange is null
    * @exceptions IndexOutOfBoundsException If the index is out of bounds
    */
    @Override
    public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("Cannot set null value");
        }
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Object oldValue = current.data;
        current.data = toChange;
        return oldValue;
    }

    /**
    * Method to check if the list is empty or not
    * 
    * @return The value to check if the list is empty or not
    */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
    * Method to check if an object exists in the list
    * 
    * @param toFind The value of the object to check
    * @return The value to check if the list contains the object or not
    * @exception NullPointerException If toFind is null
    */
    @Override
    public boolean contains(Object toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Cannot search for null value.");
        }
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(toFind)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
    * Method to add every value in the toHold into the array with all the values of the current list
    * 
    * @return The array containing all the values the list with the added toHold values
    * @exception NullPointerException If toHold is null
    */
    @Override
    public Object[] toArray(Object[] toHold) throws NullPointerException {
    	Object[] array = toHold;
        Node<T> current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    /**
    * Method to make an array with all the values of the current list
    * 
    * @return The array containing all the values the list
    */
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

    /**
    * Method that adds every value in holder to the top of the stack
    *
    * @param holder An array that holds all the object to be added
    * @return The array containing the stack values in order
    * @exceptions NullPointerException If the holder is null
    */
    public Object[] toArrayAll() {
        T[] array = (T[]) new Object[size];
        Node<T> current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

// I dunno how to explain this
    /**
    * Method that
    *
    * @return 
    */
    public utilities.Iterator iterator() {
        return (utilities.Iterator) new DLLIterator();
    }
    private class DLLIterator implements Iterator<T> {
        private Node<T> current = head;
        private Node<T> last = null;

        /**
	 * Method that checks if the iterator had any more objects in it
	 * 
	 * @return true If there is any objects left in the iterator
	 */
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        /**
	 * Method that return whatever object the cursor is pointing at
	 * 
	 * @return The value in the array that the cusor is pointing at
	 * @exceptions NoSuchElementException
	 */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            last = current;
            current = current.next;
            return data;
        }
    }
}
