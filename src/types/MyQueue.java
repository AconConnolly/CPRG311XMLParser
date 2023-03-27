package types;

import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.QueueADT;
import types.MyDLL;
import types.MyDLL.*;
import exceptions.EmptyQueueException;

/**
 * @author Quintin Mason
 *
 */

@SuppressWarnings({ "serial", "rawtypes" })
public class MyQueue<E> implements QueueADT{
	
	int size;
	Node head;
	Node tail;
	MyDLL dll;
	
	public MyQueue(int s) {
		this.size = s;
		this.dll = new MyDLL();
	}

	@SuppressWarnings("unchecked")
	
	/**
 	* Method
	*
	* @param
	* @return
	* @exceptions
 	*/

	@Override
	public void enqueue(Object toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		} else {
			if (this.isFull()) {
				throw new NullPointerException();
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

	@Override
	public Iterator<E> iterator() throws NoSuchElementException{
		return new QueueIterator(this, this.size());
	}
	private class QueueIterator implements Iterator<E> {
        private E[] queueArray;
		private int current;
		private int length;
        @SuppressWarnings("unchecked")
		public QueueIterator(MyQueue<E> queue, int length) {
        	this.queueArray = (E[]) queue.toArray();
        	this.current = 0;
        	this.length = length;
        }
        @Override
        public boolean hasNext() {
            return this.current < this.length;
        }
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
			E data = (E) this.queueArray[this.current];
            this.current++;
            return data;
        }
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(QueueADT that) {
		Iterator<E> main = this.iterator();
		Iterator<E> comp = that.iterator();
		while (main.hasNext()) {
			if (main.next() == (comp.next())) {
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
