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
	* Class to make an object of type iterator with the conents of a queue
	*
	* @exceptions NoSuchElementException
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
	* Method that checks if the iterator has any more objects in it
	* 
	* @return true if there is any objects left in the iterator
	*/
        @Override
        public boolean hasNext() {
            return this.current < this.length;
        }
		
	/**
	* Method that returns whatever object the cursor is pointing at
	* 
	* @return The value in the array that the cursor is pointing at
	* @exception NoSuchElementException
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
 	* Method to check if two stacks are equal in length and contents
	*
	* @param that The queue is being compared to
	* @return The value to check if the queues are equal or not
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
 	* Method to make an array with all the values in a stack
	*
	* @return The array containing the stack values in order
 	*/
	@Override
	public Object[] toArray() {
		return this.dll.toArrayAll();
	}

	/**
 	* Method that adds every value in holder to the top of the stack
	*
	* @param holder An array that holds all the object to be added
	* @return The array containing the stack values in order
	* @exceptions NullPointerException
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
