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
	
	@Override
	public void push(Object toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		stack.add(toAdd);
		depth++;
	}

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

	@Override
	public Object peek() throws EmptyStackException {
		if(depth == 0) {
			throw new EmptyStackException();
		}
		return (stack.get(depth-1));
	}

	@Override
	public void clear() {
		stack.clear();
		depth = 0;
		
	}

	@Override
	public boolean isEmpty() {
		return(stack.isEmpty());
	}

	@Override
	public Object[] toArray() {
		return stack.toArray();	
	}

	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		return stack.toArray(holder);
	}

	@Override
	public boolean contains(Object toFind) throws NullPointerException {
		if(stack.contains(toFind)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int search(Object toFind) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean equals(StackADT that) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int size() {
		return this.depth;
	}

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
		
		
		@Override
		public boolean hasNext() {
			if(cursor < size-1) {
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public Object next() throws NoSuchElementException {
			cursor++;
			return theArray[cursor];
		}
		
	}
	
}