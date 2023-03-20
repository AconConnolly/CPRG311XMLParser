package Tests;

import org.junit.*;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

/*
import static org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import sait.sll.utility.*;
*/

public class MyArrayListTests {
    private static ArrayList<String> testList;

    /**
     * @BeforeClass
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    /**
     * @AfterClass
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        testList = null;
    }

    /**
     * @Before
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        testList = new ArrayList<>();
    }

    /**
     * @After
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        testList.clear();

    }

    /**
     * Test method for
     */
    @Test
    public void testSize() {
        testList = new ArrayList<>();
        testList.add("one");
        testList.add("two");
        testList.add("three");
        testList.add("four");
        assertEquals(4, testList.size());

    }

    /**
     * Test method for
     */
    @Test
    public void testClear() {
        testList = new ArrayList<>();
        testList.add("test");
        testList.clear();
        assertTrue(testList.isEmpty());
    }

//    /**
//     * Test method for
//     * @throws NullPointerException
//     * @throws IndexOutOfBoundsException
//     */
//    @Test
//    public void testAdd() {
//
//    }

    /**
     * Test method for
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void testAdd() {
        testList = new ArrayList<>();
        testList.add("test");
        assertEquals(1, testList.size());

    }

    /**
     * Test method for
     * @throws NullPointerException
     */
    @Test
    public void testAddAll() {
        ArrayList<String> testList1 = new ArrayList<>();
        testList1.add("one");
        testList1.add("two");

        ArrayList<String> testList2 = new ArrayList<>();
        testList2.add("three");
        testList2.add("four");

        testList1.addAll(testList2);

        assertEquals(4, testList1.size());
        assertEquals("three",testList1.get(2));

    }

    /**
     * Test method for
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void testGet() {
        testList = new ArrayList<>();
        testList.add("one");
        testList.add("two");
        testList.add("three");

        assertEquals("one", testList.get(0));
        assertEquals("two", testList.get(1));
        assertEquals("three", testList.get(2));
    }

//    /**
//     * Test method for
//     * @throws IndexOutOfBoundsException
//     */
//    @Test
//    public void testRemove() {
//
//
//    }

    /**
     * Test method for
     * @throws NullPointerException
     */
    @Test
    public void testRemove() {
        testList = new ArrayList<>();
        testList.add("test");
        testList.remove(0);
        assertFalse(testList.contains("test"));

    }

    /**
     * Test method for
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void testSet() {
        testList = new ArrayList<>();
        testList.add("one");
        testList.add("two");
        testList.add("three");

        assertEquals("one", testList.get(0));
        assertEquals("two", testList.get(1));
        assertEquals("three", testList.get(2));

        testList.set(0, "three");

        assertEquals("three",testList.get(0));
        assertEquals("two",testList.get(1));
        assertEquals("three",testList.get(2));
    }

    /**
     * Test method for
     */
    @Test
    public void testIsEmpty() {
        testList = new ArrayList<>();
        assertTrue(testList.isEmpty());
    }

    /**
     * Test method for
     * @throws NullPointerException
     */
    @Test
    public void testContains() {
        testList = new ArrayList<>();
        testList.add("test");
        assertTrue(testList.contains("test"));

    }

    /**
     * Test method for
     * @throws NullPointerException
     */
    @Test
    public void testToArray() {
        testList = new ArrayList<>();
        testList.add("one");
        testList.add("two");
        testList.add("three");

        Object [] testArray = testList.toArray();
        assertEquals(3, testArray.length);
        assertEquals("one", testArray[0]);
        assertEquals("two", testArray[1]);

    }

//    /**
//     * Test method for
//     */
//    @Test
//    public void testToArray() {
//
//    }

    /**
     * Test method for
     * @throws AssertionError
     */
    @Test
    public void testIterator() {
        testList = new ArrayList<>();

        testList.add("one");
        testList.add("two");
        testList.add("three");

        Iterator<String> it = testList.iterator();
        assertTrue(it.hasNext());
        assertEquals("one", it.next());
        assertEquals("two", it.next());
        assertTrue(it.hasNext());

    }

    /**
     * Error when trying to call get when the index is out of bounds
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void testIndexOut() {
        testList = new ArrayList<>();
        testList.add("one");
        testList.add("two");

        testList.get(4);
    }

    /**
     * Error when trying to remove from an index that is out of bounds
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void testRemoveEmptyList() {
        testList = new ArrayList<>();
        testList.add("one");
        testList.add("two");
        testList.remove(3);
    }

    /**
     * Error when trying to add a NULL value to an empty list
     * @throws NullPointerException
     */
    @Test
    public void testAddNull() {
        testList = new ArrayList<>();
        testList.add("one");
        testList.add("two");

        testList.add(1,null);
    }

    /**
     * Error when trying to set a value that is out of bounds
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void testSetIndexOut() {
        testList = new ArrayList<>();
        testList.add("one");
        testList.add("two");

        testList.set(2,"three");
    }

    /**
     * Error when trying to add with a value that is out of bounds
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void testAddIndexOut() {
        testList = new ArrayList<>();
        testList.add("one");
        testList.add("two");

        testList.set(3,"three");
    }

    /**
     * Error when trying to add variable that is of the wrong type
     * @throws IllegalArgumentException
     */
//    @Test
//    public void testDifferentType() {
//        testList = new ArrayList<>();
//
//        try {
//            testList.add(1);
//            fail("Expected an IllegalArgumentException to be thrown");
//        } catch (IllegalArgumentException e) {
//            //Pass
//        }
//    }

}
