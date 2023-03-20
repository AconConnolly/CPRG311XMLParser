package ADTs;

import java.util.Iterator;

/**
 * StackADT.java
 *
 * @author Alex, Quintin
 * @version 1.0
 *
 * Class Definition: This interface represents a Queue object
 */
public interface QueueADT <E> {

    public void newQueue();
    /**
     * Mutator
     * Creates a new Queue
     *
     * PreCondition: No previous/existing queue.
     *
     * PostCondition: new Queue created successfully
     */

    public void peek();
    /**
     * Mutator
     * Retrieves, but does not remove the head of the queue,
     * and prints it to the console.
     *
     * PreCondition: A queue with at least one object.
     *
     * PostCondition: The head of the queue has been printed to the console
     *
     * @exception EmptyStackException if the Queue is empty.
     *
     */
    public void dequeue();
    /**
     * Mutator
     * Removes the head of the queue.
     *
     * PreCondition: The queue has not been closed.
     *
     * PostCondition: As long as the queue was not empty,
     * the head of the queue has been removed and the size decremented by one.
     *
     * @exception ClassCastException if the type of element in the queue is
     * incompatible with this method.
     *
     */
    public void enqueue();
    /**
     * Mutator
     * Inserts the specified element(s) into the queue
     *
     * PreCondition: The queue has enough space/capacity to hold the new elements
     * being passed to it. Element cannot be NULL.
     *
     * PostCondition: As long as the queue was not empty, the element passed to it
     * is placed at the end of the queue (space providing).
     * Size would also be increased by one.
     *
     * @exception ClassCastException if the class of the element being added to the queue
     * is incompatible with the rest of the queue
     *
     */
    public void first();
    /**
     * Accessor
     * Method to see what the first object in the queue is. Unlike peek(), use when
     * you know the queue is not empty.
     *
     * PreCondition: A queue object.
     *
     * PostCondition: The object that is the first member in the queue
     *
     *@exception EmptyStackException called if the queue object
     * called is either empty or does not exist (NullPointerException)
     */
    public boolean isEmpty();
    /**
     * Transformer
     * Method to determine whether the queue has any objects.
     *
     * PreCondition: A queue object.
     *
     * PostCondition: Boolean value shows true if the size of the Queue is 0
     * but false if the Queue has any objects.
     *
     *@exception nullPointerException called if the queue object called does not exist
     */
    public void size();
    /**
     * Accessor
     * Method to see what the size of the queue is
     *
     * PreCondition: A queue object
     *
     * PostCondition: Integer value that is the number of objects in the queue
     *
     * @exception NullPointerException if the stack is empty
     */
    public Iterator<E> iterator();
    /**
     * Mutator
     * This method returns an iterator over all elements of the queue.
     *
     * PreCondition: Valid Queue object.
     *
     * PostCondition: Returns a valid iterator object that is able to traverse over
     * the elements in proper order.
     *
     * @exception NullPointerException if the queue is empty.
     *
     */
    public Object toArray(E[] copy);
    /**
     * Accessor
     * Provides an array containing all the elements in the Queue (a copy) in the
     * same order.
     *
     * PreCondition: 'copy' must not be NULL.
     *
     * PostCondition: The returned array has all the elements in the queue in the
     * correct order. top of queue -> first element.
     *
     * @exception NullPointerException if the array is Null.
     *
     * @return Array object of type E.
     */
    public boolean isFull();
    /**
     * Accessor
     * Determine whether the queue is at maximum. Useful for fixed-sized queues.
     *
     * PreCondition: A valid Queue object.
     *
     * PostCondition: Unnecessary documentation as there is no modification or side effects.
     *
     * @exception UnsupportedOperationException if the queue does not have a fixed size
     * or does not keep track of the length.
     *
     */
    public void dequeueAll();
    /**
     * Mutator
     * Removes all the elements from the Queue.
     *
     * PreCondition: The queue must not be empty/
     *
     * PostCondition: That the queue is empty after the method call.
     *
     *@exception ClassCastException if an element in the queue cannot
     * be cast to the expected type. A queue of Strings cannot successfully
     * dequeue an element that is not String.
     *
     */
    public boolean equals(QueueADT<E> that);
    /**
     * Accessor
     * Compares the queue with a specified queue to check whether they are equal.
     * They are compared based on size and whether they contain the same elements
     * in the same order.
     * If they are equal -> true, if not equal -> false.
     *
     * PreCondition: the passed method 'that' must not be NULL.
     *
     * PostCondition: that neither the queue passed, nor the original queue are modified.
     *
     * @exception ClassCastException if the queue passed to the method is not
     * compatible with the elements in the specified queue.
     *
     */


}
