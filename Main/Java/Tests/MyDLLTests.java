package Tests;

import Type.DoublyLinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyDLLTests {
    private static DoublyLinkedList dll;


    /**
     * @BeforeClass
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        dll = new DoublyLinkedList();
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
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

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
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
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
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
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
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        assertEquals(3, dll.size());

        dll.deleteFromFront();

        assertEquals(Integer.valueOf(20), dll.head.getData());
        assertEquals(2, dll.size());
    }

    /**
     * Test method for
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void isClear() {
        dll = new DoublyLinkedList();
        dll.clear();
        assert dll.size() == 0;
        assertEquals(0, dll.size());
    }

    /**
     * Test method for
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testSize() {
        dll = new DoublyLinkedList();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        assert dll.size() == 3;
    }

    /**
     * Test method for
     * @throws NullPointerException
     *
     * FAILS
     */
    @Test
    public void testAddAll() {
        dll = new DoublyLinkedList();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);

        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll2.insertAtEnd(40);
        dll2.insertAtEnd(50);

        dll.addAll(dll2);

        assert dll.size() == 5;

    }

    /**
     * Test method for
     * @throws IndexOutOfBoundsException
     *
     * FAILS
     */
    @Test
    public void testGet() {
        dll = new DoublyLinkedList();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);

        assertEquals(10, (int) dll.get(0));
        assertEquals(20, (int) dll.get(1));
        assertEquals(30, (int) dll.get(2));
        assertNull(dll.get(3));
    }

    /**
     * Test method for
     * @throws NullPointerException
     *
     * FAILS
     */
    @Test
    public void testToArray() {
        dll = new DoublyLinkedList();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        Object[] expected = {10,20,30};
        assertArrayEquals(expected,dll.toArray());
    }

    /**
     * Test method for
     * @throws AssertionError
     *
     * FAILS
     */
    @Test
    public void testIterator() {
        dll = new DoublyLinkedList();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);

        Iterator ir = dll.iterator();
        assertTrue(ir.hasNext());
        assertEquals(10, ir.next());
        assertTrue(ir.hasNext());
        assertEquals(20, ir.next());
        assertTrue(ir.hasNext());
        assertEquals(30, ir.next());

    }

    /**
     * Test method for
     * @throws NullPointerException
     *
     * FAILS
     */
    @Test
    public void testContains() {
        dll = new DoublyLinkedList();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);

        assertFalse(dll.contains(4));
        dll.insertAtEnd(40);
        assertTrue(dll.contains(40));
    }


}