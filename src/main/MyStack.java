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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object toFind) throws NullPointerException {
		for (int k = 0; k < stack.length - 1; k++) {
			if ()
		}
		
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
