package queue;

import java.util.Iterator;
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
	Node next;
	Node previous;
	DoublyLinkedList dll;
	
	public MyQueue(int s) {
		this.size = s;
		this.head = null;
		this.tail = null;
		this.next = null;
		this.previous = null;
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
			} else if (this.isEmpty()) {
				this.dll.insertAtEnd(toAdd);
				this.tail.data = toAdd;
				this.head.data = toAdd;
			} else {
				this.dll.insertAtEnd(toAdd);
				this.tail.data = toAdd;
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
		return this.head.data;
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

	@Override
	public Iterator iterator() {
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator<E> {
        @SuppressWarnings("unchecked")
		private Node<E> current = head;
        private Node<E> last = null;

        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            last = current;
            current = current.next;
            return data;
        }

        @SuppressWarnings("unchecked")
		@Override
        public void remove() {
            if (last == null) {
                throw new IllegalStateException();
            }
            if (last.previous == null) {
                head = last.next;
                if (head != null) {
                    head.previous = null;
                } else {
                    tail = null;
                }
            } else if (last.next == null) {
                tail = last.previous;
                tail.next = null;
            } else {
                last.previous.next = last.next;
                last.next.previous = last.previous;
            }
            size--;
            last = null;
        }
	}

	@Override
	public boolean equals(QueueADT that) {
		if (this.iterator() == that.iterator()) {
			return true;
		} else {
			return false;
		}
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
