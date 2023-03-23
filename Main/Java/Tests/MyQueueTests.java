package tests;

import static org.junit.jupiter.api.Assertions.*;

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
	
	
	MyQueue testQueue = new MyQueue(5);
	
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
	 * @throws EmptyQueueException 
	 */
	@Test
	void testEnqueue() throws EmptyQueueException {
		testQueue.enqueue(1);
		testQueue.enqueue(3);
		
		// Test the queue is not empty.
		assertFalse(testQueue.isEmpty());
		
		// Test the value at the front of the queue is 1
		assertEquals(1, testQueue.peek());
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
	}

	/**
	 * Test method for {@link queue.MyQueue#peek()}.
	 */
	@Test
	void testPeek() throws EmptyQueueException{
		// Test EmptyQueueException is thrown due to the queue being empty
		try {
			testQueue.peek();
			fail();
		} catch (EmptyQueueException e) {
		}
		
		testQueue.enqueue(1);
		
		// Test the value shown is 1
		assertEquals(1, testQueue.peek());
		
		testQueue.enqueue(2);
		
		// Test the value shown is 1
		assertEquals(1, testQueue.peek());
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
	}

	/**
	 * Test method for {@link queue.MyQueue#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link queue.MyQueue#equals(ADTs.QueueADT)}.
	 */
	@Test
	void testEquals() {
		MyQueue goodQueue = new MyQueue(5);
		MyQueue badQueue = new MyQueue(5);
		
	}

	/**
	 * Test method for {@link queue.MyQueue#toArray()}.
	 */
	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link queue.MyQueue#toArray(java.lang.Object[])}.
	 */
	@Test
	void testToArrayObjectArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link queue.MyQueue#isFull()}.
	 */
	@Test
	void testIsFull() {
		fail("Not yet implemented");
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
