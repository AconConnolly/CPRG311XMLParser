package Tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import types.MyStack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyStackTests {
    private static MyStack<Integer> testStack;

    /**
     * @BeforeClass
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        testStack = new MyStack<>();
    }

    /**
     * @AfterClass
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        testStack = null;
    }

    /**
     * @After
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        testStack.clear();

    }

    /**
     * Test method for
     */
    @Test
    public void testSize() {
        testStack = new MyStack<>();
        assertEquals(0, testStack.size());
        testStack.push(1);
        assertEquals(1, testStack.size());
        testStack.push(2);
        assertEquals(2, testStack.size());
        testStack.push(3);
        assertEquals(3, testStack.size());

        testStack.pop();
        assertEquals(2,testStack.size());

    }

    /**
     * Test method for
     */
    @Test
    public void testClear() {
        testStack = new MyStack<>();

        testStack.push(1);
        testStack.push(2);
        testStack.push(3);

        testStack.clear();

        assertTrue(testStack.isEmpty());
    }

    /**
     * Test method for
     */
    @Test
    public void testPush() {
        testStack = new MyStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);

        assertEquals(4,testStack.size());
    }

    /**
     * Test method for
     */
    @Test
    public void testPop() {
        testStack = new MyStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);

        assertEquals(3,testStack.size());
        Integer testPop = (Integer) testStack.pop();
        assertEquals(Integer.valueOf(3), testPop);
    }

    /**
     * Test method for
     */
    @Test
    public void testPeek() {
        testStack = new MyStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        Integer testPeek = (Integer) testStack.peek();
        assertEquals(4, testStack.size());
        assertEquals(Integer.valueOf(4),testPeek);

    }

    /**
     * Test method for
     */
    @Test
    public void testIsEmpty() {
        testStack = new MyStack<>();
        assertTrue(testStack.isEmpty());
        testStack.push(1);
        assertFalse(testStack.isEmpty());
    }

    /**
     * Test method for
     * @throws NullPointerException
     */
    @Test
    public void testContains() {
        testStack = new MyStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        assertFalse(testStack.contains(4));
        testStack.push(4);
        assertTrue(testStack.contains(4));
    }

    /**
     * Test method for
     * @throws NullPointerException
     */
    @Test
    public void testToArray() {
        testStack = new MyStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);

        Object [] testArray = testStack.toArray();

        assertEquals(3, testArray.length);
        assertEquals(2, testArray[1]);

    }
    
    /**
     * Test the toArray(object[])
     */
    @Test
    public void testToArrayWithArray() {
        testStack = new MyStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);

        Object [] testArray = new Object[10];

        testStack.toArray(testArray);
        assertEquals(1, testArray[0]);
        assertEquals(2, testArray[1]);
        assertEquals(3, testArray[2]);

    }

    /**
     * Test method for
     * @throws AssertionError
     */
    @Test
    public void testIterator() {
        testStack = new MyStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);

        utilities.Iterator ir = testStack.iterator();
        assertTrue(ir.hasNext());
        assertEquals(Integer.valueOf(3), ir.next());
        assertTrue(ir.hasNext());
        assertEquals(Integer.valueOf(2), ir.next());
        assertTrue(ir.hasNext());
        assertEquals(Integer.valueOf(1), ir.next());
        assertFalse(ir.hasNext());
    }

//    /**
//     * Test method for trying to add to a stack that does not have space.
//     * @throws StackOverflowError
//     */
//    @Test
//    public void testPushStackFull() {
//        Stack<Integer> testStack = new Stack<>(2);
//        testStack.push(1);
//        testStack.push(2);
//        testStack.push(3);
//    }

    /**
     * Error when trying to pop an empty stack
     * @throws NoSuchElementException
     */
    @Test
    public void testPopEmptyStack() {
        testStack = new MyStack<>();
        assertThrows(EmptyStackException.class,() -> testStack.pop());
    }

    /**
     * Error when trying to peek an empty stack
     * @throws NoSuchElementException
     */
    @Test
    public void testPeekEmptyStack() {
        testStack = new MyStack<>();
        assertThrows(EmptyStackException.class,() -> testStack.peek());
    }

    /**
     * Error when trying to push a NULL value to an empty stack
     * @throws NullPointerException
     */
    @Test
    public void testPushNull() {
        testStack = new MyStack<>();
        assertThrows(NullPointerException.class,() -> testStack.push(null));
    }

    /**
     * Ment to test if the Equals method works
     * 
     */
    @Test
    public void testEquals() {
    	testStack = new MyStack<>();
    	testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        
        MyStack<Integer> compareStack = new MyStack<>();
        
        compareStack.push(1);
        compareStack.push(2);
        compareStack.push(3);
        
        assertTrue(testStack.equals(compareStack));
        
        compareStack.push(7);
        assertFalse(testStack.equals(compareStack));
        
        MyStack<Integer> compareStack2 = new MyStack<>();
        
        compareStack2.push(1);
        compareStack2.push(2);
        compareStack2.push(5);
        
        assertFalse(testStack.equals(compareStack2));
    }
    
    
    /**
     * Test for the search() method
     * 
     */
    @Test
    public void testSearch() {
    	testStack = new MyStack<>();
    	testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        
        assertEquals(2, testStack.search(1));
        assertEquals(0, testStack.search(3));
        assertEquals(-1, testStack.search(7));
    }
}