package types;

import java.util.NoSuchElementException;

import utilities.ListADT;

/**
 * Class to make a MyArrayList object 
 * @author Matthew, Migule
 *
 * @param <T> allows you to set a specific type for the arrayList
 */
public class MyArrayList<T> implements ListADT{

	int size;
	Object[] array;
	
	/**
	 * Constructor for a MyArrayList object
	 * 
	 */
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
	 * @return true if the object was added 
	 * 
	 * @exception NullPointerException if the object is null
	 * @exception IndexOutOfBoundsException if the index you want to add to is outside of the bounds
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
	 * @return true of the object was added 
	 * 
	 * @exception NullPointerException if the object to be added is null
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
	 * Method that add whatever is in the list to the end of the arrayList
	 * 
	 * @param toAdd a ListADT child object that stors what is to be added to the arrayList
	 * 
	 * @return true if everything was added
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
	 * @exception IndexOutOfBoundsException if the index is outside of the arrayList size
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
	 * @exception IndexOutOfBoundsException if the index is outside of the arrayList size
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
			this.size = size - 1;		
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
	 * @exception NullPointerException if the object to remove is null
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
	 * Method to set an object to a value at a specified index
	 * 
	 * @return the value stored in the current index
	 * 
	 * @exception NullPointerException if toChange is null
	 * @exception IndexOutOfBoundsException if the index specifed it to large
	 */
	@Override
	public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
		Object o = null;
		if(toChange == null) {
			throw new NullPointerException();
		}
		if(index > size) {
			throw new IndexOutOfBoundsException("This index is out of bounce");
		}
		o = this.array[index];
		this.array[index] = toChange;
		return o;
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
	 * @exception NullPointerException if toFind is null
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
	 * @param toHold an array of the value to be stored in the array
	 * @return The array containing the list values in order
	 * 
	 * @exception NullPointerException if anything in the toHold is null
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
	 * Method to make an Iterator for everything stored in the arrayList
	 * 
	 * @return an Iterator object
	 */
	@Override
	public utilities.Iterator iterator() {
		  return new Iterator(this.array);
	}
	
	/**
	 * this class extends the Iterator interface and makes an iterator of type arrayList
	 * @author Matthew, Miguel
	 *
	 */
	class Iterator implements utilities.Iterator{

		int cursor;
		Object [] theArray;
		
			/**
			 * 
			 * @param array is the list of object to be added to the iterator
			 */
			Iterator(Object[] array){
				cursor = -1;
				theArray = new Object[array.length];
				
				for(int i = 0; i<(array.length); i++) {
					theArray[i] = array[i];
				}
			}
			
		/**
		 * method that checks if the iterator had any more objects in it
		 * 
		 * @return true if there is anything object left in the iterator
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
		 * method the return whatever object the cursor is pointing at
		 * 
		 * @return the value in the array that the cusor is pointing at
		 */
		@Override
		public Object next() throws NoSuchElementException {
			this.cursor++;
			return theArray[cursor];
		}
		
	}
}
