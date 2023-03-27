package types;


import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import utilities.StackADT;

/**
 * Class to make an object of type MyStack
 * 
 * @author Matthew, Migule
 *
 * @param <E> allows you to make a stack of a specific type
 */
public class MyStack<E> implements StackADT {
	
	int depth;
	MyArrayList stack;

	/**
	 * Construcor to make an object of Type MyStack
	 */
	public MyStack() {
		depth = 0;
		stack = new MyArrayList();
	}
	
	/**
	 * Method to add an object type into a stack
	 * 
	 * @param toAdd The object to be added to the top of the stack
	 * 
	 * @exception NullPointerException If toAdd is null
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
	 * @exception EmptyStackException If the depth of the stack is 0
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
	 * @exception EmptyStackException If the depth of the stack is 0
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
	 * Method to make an array with all the values in a stack
	 * 
	 * @return The array containing the stack values in order
	 */
	@Override
	public Object[] toArray() {
		return stack.toArray();	
	}

	/**
	 * Method that adds every value in holder to the top of the stack
	 * 
	 * @param holder An array that holds all the objects to be added
	 * @return The array containing the stack values in order
	 * @exception NullPointerException If any values in the array are null
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
	 * @exception NullPointerException If toFind is null
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
	 * @return The position of the object in the stack, -1 if its not there or the index if it's found
	 */
	@Override
	public int search(Object toFind) {
		if(stack.contains(toFind)) {
			Iterator theList = (MyStack<E>.Iterator) this.iterator();
			int i = 0;
			int location = -1;
			while(theList.hasNext()) {
				if(theList.next() == toFind) {
					location = i;
				}
				i++;
			}
			return location;
		}
		else {
			return -1;
		}
	}
	
	/**
	 * Method to check if two stacks are equal in depth and contents
	 * 
	 * @param that The stack its being compared to
	 * @return The value to check if the stacks are equal in depth and contents
	 */
	@Override
	public boolean equals(StackADT that) {
		if(that.size() != this.size()) {
			return false;
		}
		Iterator main =  new Iterator(stack);
		Iterator compare =  (MyStack<E>.Iterator) that.iterator();
		
		while(main.hasNext()) {
			if(main.next() != compare.next()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method to return the depth of a stack
	 * 
	 * @return The depth of the stack
	 */
	@Override
	public int size() {
		return this.depth;
	}

	/**
	 * Method to get an iterator that has everything in the stack
	 * 
	 * @return An Iterator object containing the contents of the stack
	 */
	@Override
	public utilities.Iterator iterator() {
		return new Iterator(stack);
	}

	/**
	 * Class to make an object of type iterator with the conents of a stack
	 * 
	 * @author Matthew, Migule
	 *
	 */
	public class Iterator implements utilities.Iterator{

		int cursor;
		Object [] theArray;
		int size;
		
		/**
		 * Constructor to make an Iterator object 
		 * 
		 * @param array The contents of the stack
		 */
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
		 * Method that checks if the iterator had any more objects in it
		 * 
		 * @return true If there is any objects left in the iterator
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
		 * Method that return whatever object the cursor is pointing at
		 * 
		 * @return The value in the array that the cusor is pointing at
		 * @exceptions NoSuchElementException
		 */
		@Override
		public Object next() throws NoSuchElementException {
			cursor++;
			return theArray[cursor];
		}
		
	}
	
}
