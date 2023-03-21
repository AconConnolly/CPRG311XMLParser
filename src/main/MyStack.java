package main;

import java.util.Collection;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import utilities.StackADT;

import main.MyArrayList;

public class MyStack<E> implements StackADT {
	
	int depth;
	MyArrayList stack;

	public MyStack() {
		depth = 0;
		stack = new MyArrayList();
	}
	
	/**
	 * Method to add an object type into a stack
	 * 
	 * @param toAdd The object to be added to the top of the stack
	 * 
	 * @exception NullPointerException
	 */
	@Override
	public void push(Object toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		stack.add(toAdd);
		depth++;
	}

	/**
	 * Method to get the value of the object on top of the stack and remove it from the stack afterwards
	 * 
	 * @return The value of the object on the top of the stack
	 * 
	 * @exception EmptyStackException
	 */
	@Override
	public Object pop() throws EmptyStackException {
		if(depth == 0) {
			throw new EmptyStackException();
		}
		Object o = stack.get(depth-1);
		stack.remove(depth-1);
		depth--;
		return o;
	}

	/**
	 * Method to get the value of the object on top of the stack
	 * 
	 * @return The value of the object on the top of the stack
	 * 
	 * @exception EmptyStackException
	 */
	@Override
	public Object peek() throws EmptyStackException {
		if(depth == 0) {
			throw new EmptyStackException();
		}
		return (stack.get(depth-1));
	}

	/**
	 * Method to remove all the values in a stack leaving it empty
	 */
	@Override
	public void clear() {
		stack.clear();
		depth = 0;
		
	}

	/**
	 * Method to check if a stack is empty or not
	 * 
	 * @return The value to check if the stack is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return(stack.isEmpty());
	}

	/**
	 * Method to get all the values in a stack
	 * 
	 * @return The array containing the stack values in order
	 */
	@Override
	public Object[] toArray() {
		return stack.toArray();	
	}

	/**
	 * Method
	 * 
	 * @param holder ff
	 * @return The array containing the stack values in order
	 * 
	 * @exception NullPointerException
	 */
	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		return stack.toArray(holder);
	}

	/**
	 * Method to check if an object exists in a stack
	 * 
	 * @param toFind The value of the object to check
	 * @return The value to check if the stack contains the object or not
	 * 
	 * @exception NullPointerException
	 */
	@Override
	public boolean contains(Object toFind) throws NullPointerException {
		if(stack.contains(toFind)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Method to find the position of a specific object in a stack
	 * 
	 * @param toFind The value of the object to find
	 * @return The position of the object in the stack
	 */
	@Override
	public int search(Object toFind) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Method to check if two stacks are equal in depth
	 * 
	 * @param that
	 * @return The value to check if the stacks are in equal depth
	 */
	@Override
	public boolean equals(StackADT that) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Method to return the depth of a stack
	 * 
	 * @return The depth size
	 */
	@Override
	public int size() {
		return this.depth;
	}

	/**
	 * 
	 */
	@Override
	public utilities.Iterator iterator() {
		return new Iterator(stack);
	}

	class Iterator implements utilities.Iterator{

		int cursor;
		Object [] theArray;
		int size;
		
		Iterator(MyArrayList array){
			cursor = -1;
			theArray = new Object[array.size];
			size = 0;
			
			for(int i = 0; i<(array.size); i++) {
				theArray[i] = array.get(array.size-i-1);
				size++;
			}
		}
		
		
		/**
		 * 
		 * @return
		 */
		@Override
		public boolean hasNext() {
			if(cursor < size-1) {
				return true;
			}
			else {
				return false;
			}
		}

		/**
		 * 
		 * @return
		 * 
		 * @exception NoSuchElementException
		 */
		@Override
		public Object next() throws NoSuchElementException {
			cursor++;
			return theArray[cursor];
		}
		
	}
	
}