package main;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import utilities.ListADT;

public class MyArrayList<T> implements ListADT{

	int size;
	Object[] array;
	
	public MyArrayList(){
		size = 0;
		final int default_size = 10;
		array = new Object[10];
		
	}

	/**
	 * Method to return the size of the array
	 * 
	 * @return The size of the array list
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Method to remove all data inside the array
	 */
	@Override
	public void clear() {
		int i = 0;
		for(Object theThing: this.array) {
			array[i] = null;
			if(size > 0) {
				this.size -= 1;
			}
			i++;
		}
		
	}

	/**
	 * Method to add an object into the array list at a specific index
	 * 
	 * @param index The position of where the object will be added in the list
	 * @param toAdd The value of object to add
	 * 
	 * @return
	 * 
	 * @exception NullPointerException
	 * @exception IndexOutOfBoundsException
	 */
	@Override
	public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(toAdd == null) {
			throw new NullPointerException("Value Added if Null");
		}
		if(index > size) {
			throw new IndexOutOfBoundsException("This index is out of bounce");
		}
		if(this.size == this.array.length) {
			Object[] biggerArray = new Object[this.array.length + 10];
			int i = 0;
			for(Object theThing: this.array) {
				biggerArray[i] = theThing;
				i++;
			}
			this.array = biggerArray;
		}
		for(int moveTo = this.size; moveTo > index; moveTo--) {
			array[moveTo] = array[moveTo-1];
		}
		array[index] = toAdd;
		size++;
		
		return true;
	}

	/**
	 * Method to add an object into the array list
	 * 
	 * @param toAdd The value of object to add
	 * 
	 * @return
	 * 
	 * @exception NullPointerException
	 */
	@Override
	public boolean add(Object toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException("Value Added if Null");
		}
		if(size>0) {
			if(array[0].getClass() != toAdd.getClass()) {
				throw new IllegalArgumentException("this object dose not match the type stored in the array");
			}
		}
		if(this.size == this.array.length) {
			Object[] biggerArray = new Object[this.array.length + 10];
			int i = 0;
			for(Object theThing: this.array) {
				biggerArray[i] = theThing;
				i++;
			}
			this.array = biggerArray;
		}
		this.array[this.size] = toAdd;
		this.size++;
		return true;
	}

	/**
	 * Method
	 * 
	 * @param toAdd
	 * 
	 * @return
	 */
	@Override
	public boolean addAll(ListADT toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		utilities.Iterator stuff = toAdd.iterator();
		while(stuff.hasNext()) {
			Object o = stuff.next();
			if(o == null) {
				
			}
			else {
				this.add(o);
			}
		}
		return true;
	}

	/**
	 * Method to get the value of the object in the array list at a specific index
	 * 
	 * @param index The position in the list
	 * 
	 * @return The value of the object to get
	 * 
	 * @exception IndexOutOfBoundsException
	 */
	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		if(index > size) {
			throw new IndexOutOfBoundsException("Value request is out of the bounds of the arrayList");
		}
		return this.array[index];
	}

	/**
	 * Method to remove an object in the array list at a specific position
	 * 
	 * @param index The position in the list
	 * 
	 * @return The value of the object to remove
	 * 
	 * @exception IndexOutOfBoundsException
	 */
	@Override
	public Object remove(int index) throws IndexOutOfBoundsException {
		if(index > size) {
			throw new IndexOutOfBoundsException("There is nothing in this ArrayList");
		}
		Object whatWasRemoved;
		if(index == this.size-1) {
			whatWasRemoved = array[index];
			array[index] = null;
			this.size =- 1;		
		}
		else {
			whatWasRemoved = array[index];
			array[index] = null;
			int i = 1;
			this.size =- 1;	
			while(index < this.size-2) {
				array[index] = array[index+i];
				index++;
				i++;
			}
		}
		return whatWasRemoved;
	}

	/**
	 * Method to remove an object in the array list with a specific object value
	 * 
	 * @param toRemove The value of the object to be removed
	 * 
	 * @return The value of the object to remove
	 * 
	 * @exception NullPointerException
	 */
	@Override
	public Object remove(Object toRemove) throws NullPointerException {
		boolean found = false;
		Object itsGone = null;
		if(this.contains(toRemove)) {
			int toFill = 0;
			while(found == false) {
				if(this.array[toFill] == toRemove){
					found = true;
					itsGone = array[toFill];
					array[toFill] = null;
					toFill--;
				}
				toFill++;
			}
			while(toFill<size){
				array[toFill] = array[toFill+1];
				toFill++;
			}
			size--;
			return itsGone;
		}
		else {
			throw new NullPointerException("Value is not in the ArrayList");
		}
	}

	/**
	 * Method to 
	 * 
	 * @return
	 * 
	 * @exception NullPointerException
	 * @exception IndexOutOfBoundsException 
	 */
	@Override
	public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(toChange == null) {
			throw new NullPointerException();
		}
		if(index > size) {
			throw new IndexOutOfBoundsException("This index is out of bounce");
		}
		this.array[index] = toChange;
		return null;
	}

	/**
	 * Method to check if a stack is empty or not 
	 * 
	 * @return The value to check if the stack is empty or not
	 */
	@Override
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		else
		return false;
	}

	/**
	 * Method to check if an object exists in the list
	 * 
	 * @param toFind The value of the object to check
	 * 
	 * @return The value to check if the stack contains the object or not
	 * 
	 * @exception NullPointerException
	 */
	@Override
	public boolean contains(Object toFind) throws NullPointerException {
		boolean found = false;
		for(Object theThing: this.array) {
			if(theThing == toFind) {
				found = true;
			}
		}
		if(found) {
			return found;
		}
		else {
			return false;
		}
	}
		
	/**
	 * Method
	 * 
	 * @param toHold ff
	 * @return The array containing the list values in order
	 * 
	 * @exception NullPointerException
	 */
	@Override
	public Object[] toArray(Object[] toHold) throws NullPointerException {
		if(toHold == null) {
			throw new NullPointerException();
		}
		for(int i = 0; i < this.size; i++) {
			toHold[i] = this.array[i];
		}
		return toHold;
	}

	/**
	 * Method to get all the values in the list
	 * 
	 * @return The array containing the list values in order
	 */
	@Override
	public Object[] toArray() {
		Object[] theArray = new Object[this.size];
		for(int i = 0; i < this.size; i++) {
			theArray[i] = this.array[i];
		}
		
		return theArray;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	@Override
	public utilities.Iterator iterator() {
		  return new Iterator(this.array);
	}
	
	class Iterator implements utilities.Iterator{

		int cursor;
		Object [] theArray;
		
		Iterator(Object[] array){
			cursor = -1;
			theArray = new Object[array.length];
			
			for(int i = 0; i<(array.length); i++) {
				theArray[i] = array[i];
			}
		}
			
		/**
		 * 
		 * 
		 * @return
		 */
		@Override
		public boolean hasNext() {
			if(this.cursor < size) {
				return true;
			}
			else {
				return false;
			}
		}

		/**
		 * 
		 * 
		 * @return
		 * 
		 * @exception NoSuchElementException
		 */
		@Override
		public Object next() throws NoSuchElementException {
			this.cursor++;
			return theArray[cursor];
		}
		
	}
}