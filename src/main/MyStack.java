package main;

import java.util.Collection;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

import utilities.StackADT;


public class MyStack<E> implements StackADT, Iterator {
	
	int size;
	Object[] stack;

	@Override
	public void push(Object toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object pop() throws EmptyStackException {
		Object returnVal = stack[0];
		
		stack[0] = null;
		
		return returnVal;
	}

	@Override
	public Object peek() throws EmptyStackException {
		Object returnVal = stack[0];
		
		return returnVal;
	}

	@Override
	public void clear() {
		for(int k = 0; k < this.size - 1; k++) {
			stack[k] = null;
		}		
	}

	@Override
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		} else 
		return false;
	}

	@Override
	public Object[] toArray() {
		Object tempStack[] =  new Object[this.size];
		
		for (int k = 0; k < this.size - 1; k++) {
			tempStack[k] = this.stack[k];
		}
		
		return tempStack;
	}

	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object toFind) throws NullPointerException {
		//for (int k = 0; k < stack.length - 1; k++) {
		//	if ()
		//}
		
		return false;
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
		return this.size;
	}
	
}
