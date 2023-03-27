package Tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.Test;

import exceptions.EmptyQueueException;
import types.MyQueue;
import utilities.Iterator;


/**
 * 
 * Class to test methods in the MyQueue class
 * @author Quintin Mason
 *
 */
@SuppressWarnings("rawtypes")
public class MyQueueTests {
	
	
	static MyQueue testQueue;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		testQueue = null;
	}
	
	/**
     * @Before
     * @throws java.lang.Exception
     */
    @Before
    public void setUpBefore() throws Exception {
        testQueue = new MyQueue(5);
    }

    /**
     * @After
     * @throws java.lang.Exception
     */
    @After
    public void tearDownAfter() throws Exception {
    	testQueue.dequeueAll();

    }

	/**
	 * Test method for {@link queue.MyQueue#enqueue(java.lang.Object)}.
	 * @throws EmptyQueueException thrown when the peek returns nothing
	 * @throws NullPointerException thrown when the added value is null or when trying to add to a full queue
	 */
	@Test
	public void testEnqueue() throws EmptyQueueException, NullPointerException {
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
	public void testDequeue() throws EmptyQueueException {
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
	public void testPeek() throws EmptyQueueException{
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
	public void testDequeueAll() {
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
	public void testIsEmpty() {
		// Test queue is empty as nothing has been added
		assertTrue(testQueue.isEmpty());
		
		testQueue.enqueue(1);
		
		// Test queue is not empty
		assertFalse(testQueue.isEmpty());
	}

	/**
	 * Test method for {@link queue.MyQueue#iterator()}.
	 * @param <E>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <E> void testIterator() {
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		
		Iterator<E> testIterator = testQueue.iterator();
		
		// Test the iterator has a next value
		assertTrue(testIterator.hasNext());
		
		// Test the first value of the iterator is 1
		assertEquals(1, testIterator.next());
		
		// Test the next value is 2
		assertEquals(2, testIterator.next());
		
		// Test the next value is 3
		assertEquals(3, testIterator.next());
		
		// Test the next value in 4
		assertEquals(4, testIterator.next());
		
		// Test the iterator does not have a next value
		assertFalse(testIterator.hasNext());
		
		// Test the method throws NoSuchElementException
		assertThrows(NoSuchElementException.class,() -> testIterator.next());
	}

	/**
	 * Test method for {@link queue.MyQueue#equals(ADTs.QueueADT)}.
	 */
	@Test
	public void testEquals() {
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
		badQueue.enqueue(2);
		badQueue.enqueue(1);
		
		// Test the test queue equals the good queue
		assertTrue(testQueue.equals(goodQueue));
		
		// Test the test queue does not equal the bad queue
		assertFalse(testQueue.equals(badQueue));
	}

	/**
	 * Test method for {@link queue.MyQueue#toArray()}.
	 */
	@Test
	public void testToArray() {
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		Object[] obj = new Object[5];
		obj[0] = 1;
		obj[1] = 2;
		obj[2] = 3;
		obj[3] = 4;
		Object[] main = testQueue.toArray();
		
		// Test the first objects are equal in both arrays
		assertEquals(obj[0], main[0]);
		
		// Test the second objects are equal in both arrays
		assertEquals(obj[1], main[1]);
		
		// Test the third objects are equal in both arrays
		assertEquals(obj[2], main[2]);
		
		// Test the fourth objects are equal in both arrays
		assertEquals(obj[3], main[3]);
	}

	/**
	 * Test method for {@link queue.MyQueue#toArray(java.lang.Object[])}.
	 */
	@Test
	public void testToArrayObjectArray() {
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		Object[] obj = new Object[5];
		Object[] array = new Object[5];
		obj[0] = 1;
		obj[1] = 2;
		obj[2] = 3;
		obj[3] = 4;
		
		// Test both object arrays are equal
		assertEquals(obj[0], testQueue.toArray(array)[0]);
		
		// Test both object arrays are equal
		assertEquals(obj[1], testQueue.toArray(array)[1]);
		
		// Test both object arrays are equal
		assertEquals(obj[2], testQueue.toArray(array)[2]);
		
		// Test both object arrays are equal
		assertEquals(obj[3], testQueue.toArray(array)[3]);
	}

	/**
	 * Test method for {@link queue.MyQueue#isFull()}.
	 */
	@Test
	public void testIsFull() {
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
	public void testSize() {
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		
		// Test returns 4, the number of items currently in the queue
		assertEquals(4, testQueue.size());
	}

}

