package queue;

import utilities.Iterator;
import java.util.NoSuchElementException;

import ADTs.QueueADT;
import utilities.DoublyLinkedList;
import utilities.DoublyLinkedList.*;
import exceptions.EmptyQueueException;

@SuppressWarnings({ "serial", "rawtypes" })
public class MyQueue<E> implements QueueADT{
	
	int size;
	Node head;
	Node tail;
	DoublyLinkedList dll;
	
	public MyQueue(int s) {
		this.size = s;
		this.head = null;
		this.tail = null;
		this.dll = new DoublyLinkedList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void enqueue(Object toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		} else {
			if (this.isFull()) {
				System.out.println("Queue is full");
			} else {
				this.dll.insertAtEnd(toAdd);
			}
		}
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		} else {
			return this.dll.deleteFromFront().data;
		}
	}

	@Override
	public Object peek() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		} else {
			return this.dll.head.data;
		}
	}

	@Override
	public void dequeueAll() {
		this.dll.clear();
	}

	@Override
	public boolean isEmpty() {
		if (this.dll.size() <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator {
        private Node current = head;
        @Override
        public boolean hasNext() {
            return current.next != null;
        }
        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
			E data = (E) current.data;
            current = current.next;
            return data;
        }
	}
	@Override
	public boolean equals(QueueADT that) {
		while (this.iterator().hasNext()) {
			if (this.iterator().next().equals(that.iterator().next())) {
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public Object[] toArray() {
		return this.dll.toArrayAll();
	}

	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		if (this.dll.isEmpty()) {
			throw new NullPointerException();
		}else {
			return this.dll.toArray(holder);
		}
	}

	@Override
	public boolean isFull() {
		if (this.size == this.dll.size()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return this.dll.size();
	}
	
}

