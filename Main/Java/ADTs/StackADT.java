package ADTs;

import java.util.Iterator;

/**
 * StackADT.java
 *
 * @author Matthew, Migule
 * @version 1.0
 *
 * Class Definition: This interface represents a stack object
 */
public interface StackADT<E> {

 public void newStack();
 /**
  // kitty: documentation for each method is usally placed BEFORE the method signature!
  * Mutator method creates a new stack
  *
  * PreCondition: There is no available or existing stack
  *
  * PostCondition: A stack that has been created
  *
  * @exception ClassCastException if the type of stack isn't allowed
 // kitty: what is not allowed?!?!
  *
  */

 public void push(E obj);
 /**
  * Mutator methods to add a object to the top of the stack
  *
  * PreCondition: A valid object that matches the type of the stack
  // kitty: what about the argument passed in? Can it be null? If not, what will happen?
  *
  * PostCondition: A stack that has one more object added
  *
  * @exception ClassCastException If the object does not match the type of stack
  *
 // kitty: @param? what is the E?
  */

 public void pop();
 /**
  * Mutator method that removes the top object from a stack
  *
  * PreCondition: A valid stack with at least one object
  *
  * PostCondition: A stack with one less object
  *
  * @exception NullPointerException if the stack is empty
 // kitty: would it be NullPointerException or EmptyStackException?
  */

 public void peek();
 /**
  * Accessor method to show the top of the stack
  *
  * PreCondition: A stack with at least one object
  *
  * PostCondition: Reference to the object on the top of the stack
  *
  * @exception NullPointerException if the stack is empty
 // kitty: same comment as above
  */

 public boolean equals(StackADT<E> that);
 /**
  * Accessor method to show if two stacks are equal
  *
  * PreCondition: two valid stacks with at least one object
  *
  * PostCondition: boolean value depending on if the stacks are equal or not
  *
  * @exception NullPointerException if the stack is empty
 // kitty: you're already specified in the pre-condition that the stacks have at least one object/element
 // so the stack should never be empty (and even if empty - again with EmptyStackException)
  * @exception ClassCastException if the stacks are different types
 // kitty: be careful with this limitation! can different types be compared? Depends on the types and
 // implemented interfaces (e.g. Comparable)
  */

 public Iterator<E> iterator();
 /**
  * Mutator method that returned an iterator object of the whole stack
  *
  * PreCondition: A valid stack object
  *
  * PostCondition: Returned an iterator object holding the values in the stack
  // kitty: you want to explicitly state the order of the iterator (i.e. top to bottom of stack)
  *
  * @exception NullPointerException if the stack is empty
  */

 public E[] toArray(E[] copy);
 /**
  * Mutator method that to copy the array values a stack to another array stack
  *
  * PreCondition: A valid stack object
  *
  * PostCondition: Returned the object holding the values in the stack
  // kitty: again you want to specify the order: top of stack = first element
  *
  * @return Array object of type E
  * @exception NullPointerException if the stack is empty // kitty: EmptyStackException is more appropriate
  */

 public int search(E obj);
 /**
  * Accessor method to find the index of the object
  *
  * PreCondition: A valid stack object with at least one object
  *
  * PostCondition: Int value representing how far the object is in the stack
  // kitty: what does this mean? You want to specify clearly what the integer represents (e.g. first element =
  // position 1 = top of stack)
  *
  * @param obj is what the stack will be searched for
  * @return the index of the object
  */

 public boolean contains(E obj);
 /**
  * Accessor method to show if an object is in the stack
  *
  * PreCondition: A valid stack object with at least one object
  *
  * PostCondition: Boolean value of true or false if the object was found in the stack
  *
  * @exception NullPointerException if the stack is empty
  */

 public int size();
 /**
  * Accessor method to show the size of the stack
  *
  * PreCondition: A valid stack with at least one object
  *
  * PostCondition: Int value that has the size of the stack
  *
  * @exception NullPointerException if the stack is empty
 // kitty: if you already stated that the stack has at least one element, you don't need to check for this!
  */

 public boolean isEmpty();
 /**
  * Transformer method to show if a stack has any objects
  *
  * PreCondition: A stack object
  *
  * PostCondition: Boolean value of true if the size of the stack is 0
  * false if it has any objects
  */

 public void clear();
 /**
  * Mutator method that deletes all the contents in a stack
  *
  * PreCondition: Valid stack object
  *
  * PostCondition: The stack object is emptied of all its objects
  *
  * @exception NullPointerException if the stack is empty
  */
}