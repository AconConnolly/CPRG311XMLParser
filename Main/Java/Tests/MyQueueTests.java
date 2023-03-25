package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EmptyQueueException;
import queue.MyQueue;

/**
 * @author qball
 *
 */
@SuppressWarnings("rawtypes")
class MyQueueTests {
	
	
	MyQueue testQueue;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testQueue = new MyQueue(5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		testQueue.dequeueAll();
	}

	/**
	 * Test method for {@link queue.MyQueue#enqueue(java.lang.Object)}.
	 * @throws EmptyQueueException thrown when the peek returns nothing
	 * @throws NullPointerException thrown when the added value is null or when trying to add to a full queue
	 */
	@Test
	void testEnqueue() throws EmptyQueueException, NullPointerException {
		testQueue.enqueue(1);
		testQueue.enqueue(3);
		
		// Test the queue is not empty.
		assertFalse(testQueue.isEmpty());
		
		// Test the value at the front of the queue is 1
		assertEquals(1, testQueue.peek());
		
		// Test does not add the null value and throws a NullPointerException
		assertThrows(NullPointerException.class,() -> testQueue.enqueue(null));
		
		testQueue.enqueue(2);
		testQueue.enqueue(4);
		testQueue.enqueue(5);
		
		// Test throws a NullPointerException and does not add the value
		assertThrows(NullPointerException.class,() -> testQueue.enqueue(6));
	}

	/**
	 * Test method for {@link queue.MyQueue#dequeue()}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testDequeue() throws EmptyQueueException {
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		
		// Test the value removed is 1
		assertEquals(1, testQueue.dequeue());
		
		// Test the value removed is 2
		assertEquals(2, testQueue.dequeue());
		
		// Test the value removed is 3
		assertEquals(3, testQueue.dequeue());
		
		// Test the value removed is 4
		assertEquals(4, testQueue.dequeue());
		
		// Test the queue is empty
		assertTrue(testQueue.isEmpty());
		
		// Test dequeue fails when used on an empty queue and throws EmptyQueueException
		assertThrows(EmptyQueueException.class,() -> testQueue.dequeue());
	}

	/**
	 * Test method for {@link queue.MyQueue#peek()}.
	 */
	@Test
	void testPeek() throws EmptyQueueException{
		// Test EmptyQueueException is thrown due to the queue being empty
		assertThrows(EmptyQueueException.class,() -> testQueue.peek());

		
		testQueue.enqueue(1);
		
		// Test the value shown is 1
		assertEquals(1, testQueue.peek());
		
		testQueue.enqueue(2);
		
		// Test the value shown is 1
		assertEquals(1, testQueue.peek());
		
		testQueue.dequeue();
		
		// Test the value shown is 2
		assertEquals(2, testQueue.peek());
	}

	/**
	 * Test method for {@link queue.MyQueue#dequeueAll()}.
	 */
	@Test
	void testDequeueAll() {
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		testQueue.dequeueAll();
		
		// Test queue is empty
		assertTrue(testQueue.isEmpty());
	}

	/**
	 * Test method for {@link queue.MyQueue#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		// Test queue is empty as nothing has been added
		assertTrue(testQueue.isEmpty());
		
		testQueue.enqueue(1);
		
		// Test queue is not empty
		assertFalse(testQueue.isEmpty());
	}

	/**
	 * Test method for {@link queue.MyQueue#iterator()}.
	 */
	@Test
	void testIterator() {
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		
		// Test the iterator has a next value
		assertTrue(testQueue.iterator().hasNext());
		
		// Test the first value of the iterator is 1
		assertEquals(1, testQueue.iterator().next());
		
		// Test the next value is 2
		assertEquals(2, testQueue.iterator().next());
		
		// Test the next value is 3
		assertEquals(3, testQueue.iterator().next());
		
		// Test the next value in 4
		assertEquals(4, testQueue.iterator().next());
		
		// Test the iterator does not have a next value
		assertFalse(testQueue.iterator().hasNext());
		
		// Test the method throws NoSuchElementException
		assertThrows(NoSuchElementException.class,() -> testQueue.iterator().next());
	}

	/**
	 * Test method for {@link queue.MyQueue#equals(ADTs.QueueADT)}.
	 */
	@Test
	void testEquals() {
		MyQueue goodQueue = new MyQueue(5);
		MyQueue badQueue = new MyQueue(5);
		
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		
		goodQueue.enqueue(1);
		goodQueue.enqueue(2);
		goodQueue.enqueue(3);
		goodQueue.enqueue(4);
		
		badQueue.enqueue(4);
		badQueue.enqueue(3);
		
		// Test the test queue equals the good queue
		assertTrue(testQueue.equals(goodQueue));
		
		// Test the test queue does not equal the bad queue
		assertFalse(testQueue.equals(badQueue));
	}

	/**
	 * Test method for {@link queue.MyQueue#toArray()}.
	 */
	@Test
	void testToArray() {
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		Object[] obj = new Object[5];
		obj[1] = 1;
		obj[2] = 2;
		obj[3] = 3;
		obj[4] = 4;
		
		// Test the queue to array equals the object array
		assertEquals(obj, testQueue.toArray());
	}

	/**
	 * Test method for {@link queue.MyQueue#toArray(java.lang.Object[])}.
	 */
	@Test
	void testToArrayObjectArray() {
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		Object[] obj = new Object[5];
		Object[] array = new Object[5];
		obj[1] = 1;
		obj[2] = 2;
		obj[3] = 3;
		obj[4] = 4;
		
		// Test both object arrays are equal
		assertEquals(obj, testQueue.toArray(array));
	}

	/**
	 * Test method for {@link queue.MyQueue#isFull()}.
	 */
	@Test
	void testIsFull() {
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		
		// Test queue is not full
		assertFalse(testQueue.isFull());
		
		testQueue.enqueue(5);
		
		// Test queue is full
		assertTrue(testQueue.isFull());
	}

	/**
	 * Test method for {@link queue.MyQueue#size()}.
	 */
	@Test
	void testSize() {
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		
		// Test returns 4, the number of items currently in the queue
		assertEquals(4, testQueue.size());
	}

}
