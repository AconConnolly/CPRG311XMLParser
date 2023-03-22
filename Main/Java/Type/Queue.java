package Type;

import ADTs.QueueADT;

import java.util.Iterator;

public class Queue<E> implements QueueADT, Iterator {
    int size = 5;
    int[] items = new int[size];
    int beg, end;

    Queue() {
        beg = -1;
        end = -1;
    }
    //Optional method if the queue is a fixed size
    boolean fullList() {
        return beg == 0 && end == size - 1;
    }

    void insertInto (int elements) {
        if (fullList()) {
            System.out.println("The queue is full");
        } else {
            if (beg == -1) {
                beg = 0;
            }
            end++;
            items[end] = elements;
            System.out.println("Insert " + elements);
        }
    }

    @Override
    public boolean equals(QueueADT that) {
        return false;
    }

    //Rerun an array containing all of the items in the queue
    public void toArray(E[] copy) {
        int i;
        if (size == 0) {
            System.out.println("Empty que");
        }
        else {
            System.out.println("\nFront Index: " + beg);
            System.out.println("Items: ");
            for (i = beg; i <= end; i++) {
                System.out.println(items[i] + " ");
            }
            System.out.println("\nRear Index: " + end);
        }
    }

    @Override
    public void newQueue() {
        Queue queTest = new Queue<>();
    }

    @Override
    public Object peek() {
        if (size == 0) {
            return null;
        } else {
            return beg;
        }
    }

    @Override
    public void dequeue() {
        int element;
        if(size == 0) {
            System.out.println("The queue is empty");
            return;
        }
        else {
            element = items[beg];
        }
        if (beg >= end) {
            beg = -1;
            end = -1;
        }
        else {
            beg++;
        }
        System.out.println(element + " Deleted");

    }

    @Override
    public void enqueue() {

    }

    @Override
    public boolean isEmpty() {
        return beg == -1;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue que = new Queue();


    }

    //Two queues must contain equal items appearing in the same order
    boolean equals(Queue<E> that) {
        return that.equals(items);
    }

    //Returns an iterator over the items contained in the stack
    Iterator<E> iterator() {
        Queue que = new Queue();
        Iterator itr = que.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        return itr;
    }

    @Override
    public Object toArray(Object[] copy) {
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void dequeueAll() {

    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}