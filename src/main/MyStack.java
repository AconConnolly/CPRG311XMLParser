package main;

import java.util.Collection;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

import utilities.StackADT;

import main.MyArrayList;


public class MyStack<E> implements StackADT, Iterator {
	
	int depth;
	MyArrayList stack;

	public MyStack() {
		depth = 0;
		stack = new MyArrayList();
	}
	@Override
	public void push(Object toAdd) throws NullPointerException {
		//Object tempArray = new Object [this.size + 1];
		
		//for (int k  = this.size + 1; k > 0; k--) {
		//	tempArray[k] = stack[k];
		//}
		
	}

	@Override
	public Object pop() throws EmptyStackException {
		/*
		Object returnVal = stack[0];
		
		stack[0] = null;
		
		return returnVal;
		*/
		
		stack.get(0);
		stack.remove(0);
		return null;
	}

	@Override
	public Object peek() throws EmptyStackException {
		/*
		Object returnVal = stack[0];
		
		return returnVal;
		*/
		stack.get(0);
		return null;
		
	}

	@Override
	public void clear() {
		/*
		for(int k = 0; k < this.size - 1; k++) {
			stack[k] = null;
		}		
		*/
		stack.clear();
		
	}

	@Override
	public boolean isEmpty() {
		stack.isEmpty();
		return false;
	}

	@Override
	public Object[] toArray() {
		/*
		Object tempStack[] =  new Object[this.size];
		
		for (int k = 0; k < this.size - 1; k++) {
			tempStack[k] = this.stack[k];
		}
		*/
		
		return stack.toArray();
		
	}

	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		return stack.toArray(holder);
	}

	@Override
	public boolean contains(Object toFind) throws NullPointerException {
		//for (int k = 0; k < stack.length - 1; k++) {
		//	if ()
		//}
		return stack.contains(toFind);
	}

	@Override
	public int search(Object toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public utilities.Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
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
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}
	
}