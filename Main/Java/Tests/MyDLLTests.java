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
     * Test method for
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void TestInsertion() {
        dll = new DoublyLinkedList();
        dll.insertAtEnd(10);

        assert dll.size() == 1;
        assert dll.head.data == 10;
        assert dll.tail.data == 10;

        dll.insertAtEnd(20);
        assert dll.size() == 2;
        assert dll.head.data == 10;
        assert dll.tail.data == 20;
    }

    /**
     * Test method for
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void testDeletion() {
        dll = new DoublyLinkedList();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        assert dll.size() == 3;

        DoublyLinkedList.Node deleteNode = dll.deleteFromEnd();
        assert deleteNode.data == 30;
        assert dll.size() == 2;
        assert dll.tail.data == 20;

        deleteNode = dll.deleteFromEnd();
        assert deleteNode.data == 20;
        assert dll.size() == 1;
        assert dll.tail.data == 10;
    }

    /**
     * Test method for
     * @throws NullPointerException
     *
     * PASSES
     */
    @Test
    public void isClear() {
        assert dll.size() == 0;
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

        assertEquals(10,dll.get(0));
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

        Object [] testArray = dll.toArray();
        assertEquals(3, testArray.length);
        assertEquals(10, testArray[0]);
        assertEquals(20, testArray[1]);

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