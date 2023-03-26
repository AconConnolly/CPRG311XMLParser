package Tests;

import types.MyDLL;
import utilities.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyDLLTests {
    private static MyDLL dll;


    /**
     * @BeforeClass
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        dll = new MyDLL();
    }

    /**
     * @AfterClass
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        dll = null;
    }

    /**
     * Clears the DLL
     * @After
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        dll.clear();
    }

    /**
     * Test method for whether the code can insert en element into the end of the Doubly Linked List
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testInsertAtEnd() {
    	MyDLL<String> list = new MyDLL<>();

        // Test inserting one element
        list.insertAtEnd("A");
        assertEquals(1, list.size());
        assertEquals("A", list.get(0));

        // Test inserting multiple elements
        list.insertAtEnd("B");
        list.insertAtEnd("C");
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    /**
     * Test method for whether the code can insert en element into the beginning
     * of the Doubly Linked List
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void TestInsertionAtFront() {
    	MyDLL<Integer> dll = new MyDLL<>();
        dll.insertAtEnd(10);
        dll.insertAtFront(40);

        assertEquals(Integer.valueOf(40), dll.get(0));
    }

    /**
     * Test method for whether the code can successfully delete from the end of the list
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testDeleteFromEnd() {
    	MyDLL<Integer> dll = new MyDLL<>();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        assertEquals(3, dll.size());
        dll.deleteFromEnd();

        assertEquals(Integer.valueOf(20), dll.tail.getData());
    }

    /**
     * Test method for whether the code can successfully delete from the front of the list
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testDeleteFromFront() {
    	MyDLL<Integer> dll = new MyDLL<>();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        assertEquals(3, dll.size());

        dll.deleteFromFront();

        assertEquals(Integer.valueOf(20), dll.head.getData());
        assertEquals(2, dll.size());
    }

    /**
     * Test method for determining whether the list gets cleared.
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void isClear() {
        dll = new MyDLL();
        dll.clear();
        assert dll.size() == 0;
        assertEquals(0, dll.size());
    }

    /**
     * Test method for determining the size of the DLL
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testSize() {
        dll = new MyDLL();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        assert dll.size() == 3;
    }

    /**
     * Test method for determining the size of the DLL
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testAdd() {
    	MyDLL<Integer> list = new MyDLL<Integer>();
        assertEquals(0, list.size());

        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));

        assertEquals(3, list.size());

        Object[] arr = list.toArray();
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(3, arr[2]);

        try {
            list.add(null);
            fail("Expected NullPointerException to be thrown.");
        } catch (NullPointerException e) {

        }
    }

    /**
     * Test method for determining whether an element can be added at a specific index
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testAddAtIndex() {
    	MyDLL<Integer> list = new MyDLL<Integer>();
        assertEquals(0, list.size());

        list.add(0, 1);
        list.add(1, 3);
        list.add(1, 2);

        assertEquals(3, list.size());

        Object[] arr = list.toArray();
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(3, arr[2]);

        try {
            list.add(-1, 4);
            fail("Expected IndexOutOfBoundsException to be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }

        try {
            list.add(0, null);
            fail("Expected NullPointerException to be thrown.");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    /**
     * Test method for determining whether a DLL has a 'next' element
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testHasNext() {
    	MyDLL<Integer> dll = new MyDLL<>();
        assertFalse(dll.hasNext());

        dll.insertAtEnd(1);
        assertTrue(dll.hasNext());

        dll.insertAtEnd(2);
        assertTrue(dll.hasNext());

        dll.remove(2);
        assertTrue(dll.hasNext());

        dll.remove(1);
        assertTrue(dll.hasNext());
    }


    /**
     * Test method for determining whether an array of elements can be added to another DLL.
     * @throws NullPointerException
     *
     * FAILS
     */
    @Test
    public void testAddAll() {
        dll = new MyDLL();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);

        MyDLL dll2 = new MyDLL();
        dll2.insertAtEnd(40);
        dll2.insertAtEnd(50);

        dll.addAll(dll2);

        assert dll.size() == 5;
    }

    /**
     * Test method for determining whether you can  get an element at a specific index
     * @throws IndexOutOfBoundsException
     *
     * FAILS
     */
    @Test
    public void testGet() {
        dll = new MyDLL();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);

        assertEquals(10, (int) dll.get(0));
        assertEquals(20, (int) dll.get(1));
        assertEquals(30, (int) dll.get(2));
        assertNull(dll.get(3));
    }

    /**
     * Test method for determining whether a DLL can be converted to an array
     * @throws NullPointerException
     *
     * FAILS
     */
    @Test
    public void testToArray() {
        dll = new MyDLL();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        Object[] expected = {10,20,30};
        assertArrayEquals(expected,dll.toArray());
    }
    
    /**
     * Test for the toArray(Object toHold) method 
     */
    @Test
    public void testToArrayExistingArray() {
    	dll = new MyDLL();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        
        Object [] testArray = new Object[10];
        dll.toArray(testArray);
        
        assertEquals(10, testArray[0]);
        assertEquals(20, testArray[1]);
        assertEquals(30, testArray[2]);
    }

    @Test
    public void testToArrayAll() {
    	MyDLL<Integer> dll = new MyDLL<>();
        dll.insertAtFront(10);
        dll.insertAtFront(20);
        dll.insertAtFront(30);



    }

    /**
     * Test method for determining whether the iterator is going over an empty list
     * @throws AssertionError
     *
     * FAILS
     */
    @Test
    public void testIteratorEmpty() {
        dll = new MyDLL();
        Iterator ir = dll.iterator();
        assertFalse(ir.hasNext());
    }

    /**
     * Test method for determining whether an iterator can remove an element at a given index
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testIteratorRemove() {
        dll = new MyDLL();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);

        Iterator ir = dll.iterator();
        assertTrue(ir.hasNext());
        assertEquals(10, ir.next());
        assertEquals(20, ir.next());
        assertEquals(30, ir.next());

        assertFalse(ir.hasNext());
    }

    /**
     * Test method for determining whether a DLL contains a certain element.
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testContains() {
        dll = new MyDLL();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);

        assertFalse(dll.contains(4));
        dll.insertAtEnd(40);
        assertTrue(dll.contains(30));
    }

    /**
     * Test method for determining whether a DLL is empty.
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testIsEmpty() {
        dll = new MyDLL();

        assertTrue(dll.isEmpty());

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);

        assertFalse(dll.isEmpty());

        dll.deleteFromFront();
        dll.deleteFromEnd();

        assertTrue(dll.isEmpty());
    }

    /**
     * Test method for determining whether an element can be set at a certain index.
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testSet() {
        dll = new MyDLL();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);

        assertEquals(20, dll.set(1, 50));
        assertEquals(50, dll.get(1));
    }

    /**
     * Test method for determining whether an element can be removed at a certain index.
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testRemoveAtIndex() throws IndexOutOfBoundsException {
        dll = new MyDLL();
        dll.add(10);
        dll.add(20);
        dll.add(30);
        dll.add(40);
        dll.add(50);
        assertEquals(5,dll.size());

        Object deleted = dll.remove(2);
        assertEquals(30, deleted);
        assertEquals(4, dll.size());
    }
    /**
     * Test method for determining whether a DLL can remove from the end of a list.
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testRemoveAtEnd() throws NullPointerException {
    	MyDLL<Integer> dll = new MyDLL<>();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        assertEquals(3, dll.size());
        dll.deleteFromEnd();

        assertEquals(Integer.valueOf(20), dll.tail.getData());
    }
}