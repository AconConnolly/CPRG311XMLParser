package types;

import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.QueueADT;
import types.MyDLL;
import types.MyDLL.*;
import exceptions.EmptyQueueException;

/**
 * Class to make an object of type MyQueue
 *
 * @author Quintin Mason
 *
 * @param <E> allows you to make a queue of a specific type
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
 	* Method to add an object to the back of the queue
	*
	* @param toAdd
	* @exceptions NullPointerException
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

	/**
 	* Method to remove an object on the front of the queue
	*
	* @return The value of the object that will be dequeued
	* @exceptions EmptyQueueException
 	*/
	@Override
	public Object dequeue() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		} else {
			return this.dll.deleteFromFront().data;
		}
	}

	/**
 	* Method to get the value of the object on the front of the queue
	*
	* @return The value of the object on front of the queue
	* @exceptions EmptyQueueException
 	*/
	@Override
	public Object peek() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		} else {
			return this.dll.head.data;
		}
	}

	/**
 	* Method to remove all objects in the queue leaving it empty
 	*/
	@Override
	public void dequeueAll() {
		this.dll.clear();
	}

	/**
 	* Method to check if the queue is empty or not
	*
	* @return The value to check if the queue is empty or not
 	*/
	@Override
	public boolean isEmpty() {
		if (this.dll.size() <= 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
 	* Method
	*
	* @param
	* @return
	* @exceptions
 	*/
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
		
	/**
 	* Method
	*
	* @param
	* @return
	* @exceptions
 	*/
        @Override
        public boolean hasNext() {
            return this.current < this.length;
        }
		
	/**
 	* Method
	*
	* @param
	* @return
	* @exceptions
 	*/
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
	
	/**
 	* Method
	*
	* @param
	* @return
	* @exceptions
 	*/
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

	/**
 	* Method
	*
	* @param
	* @return
	* @exceptions
 	*/
	@Override
	public Object[] toArray() {
		return this.dll.toArrayAll();
	}

	/**
 	* Method
	*
	* @param
	* @return
	* @exceptions
 	*/
	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		if (this.dll.isEmpty()) {
			throw new NullPointerException();
		}else {
			return this.dll.toArray(holder);
		}
	}

	/**
 	* Method to check if the queue is full
	*
	* @return The value to check if the queue is full or not
 	*/
	@Override
	public boolean isFull() {
		if (this.size == this.dll.size()) {
			return true;
		} else {
			return false;
		}
	}

	/**
 	* Method to get the queue size
	*
	* @return The size of the queue
 	*/
	@Override
	public int size() {
		return this.dll.size();
	}
	
}
