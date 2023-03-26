package Tests;

import org.junit.*;
import types.MyArrayList;
import static org.junit.Assert.*;

public class MyArrayListTests {
    private static MyArrayList<String> testList;

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
        testList = new MyArrayList<>();
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
        testList = new MyArrayList<>();
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
        testList = new MyArrayList<>();
        testList.add("test");
        testList.clear();
        assertTrue(testList.isEmpty());
    }

    /**
     * Test method for
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void testAdd() {
        testList = new MyArrayList<>();
        testList.add("test");
        assertEquals(1, testList.size());

    }
    
    
    /**
     * Test for adding to a sepecific index
     * 
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void testAddAtIndex() {
    	 testList = new MyArrayList<>();
         testList.add("test");
         testList.add("other");
         testList.add("stuff");
         testList.add(1,"theRealTest");
         
         assertEquals(4, testList.size());
         assertEquals("test", testList.get(0));
         assertEquals("theRealTest", testList.get(1));
         assertEquals("stuff", testList.get(3));
         
    }

    /**
     * Test method for
     * @throws NullPointerException
     */
    @Test
    public void testAddAll() {
        MyArrayList<String> testList1 = new MyArrayList<>();
        testList1.add("one");
        testList1.add("two");

        MyArrayList<String> testList2 = new MyArrayList<>();
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
        testList = new MyArrayList<>();
        testList.add("one");
        testList.add("two");
        testList.add("three");

        assertEquals("one", testList.get(0));
        assertEquals("two", testList.get(1));
        assertEquals("three", testList.get(2));
    }

    /**
     * Test method for
     * @throws NullPointerException
     */
    @Test
    public void testRemove() {
        testList = new MyArrayList<>();
        testList.add("test");
        testList.remove(0);
        assertFalse(testList.contains("test"));
        
    }
    
    /**
     * Test the removed speficfic object method
     * 
     */
    @Test
    public void testRemoveObject() {
        testList = new MyArrayList<>();
        testList.add("test");
        testList.add("other");
        testList.add("stuff");
        testList.remove("other");
        
        assertEquals(2, testList.size());
        assertEquals("test", testList.get(0));
        assertEquals("stuff", testList.get(1));


    }

    /**
     * Test method for
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void testSet() {
        testList = new MyArrayList<>();
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
        testList = new MyArrayList<>();
        assertTrue(testList.isEmpty());
    }

    /**
     * Test method for
     * @throws NullPointerException
     */
    @Test
    public void testContains() {
        testList = new MyArrayList<>();
        testList.add("test");
        assertTrue(testList.contains("test"));

    }

    /**
     * Test method for
     * @throws NullPointerException
     */
    @Test
    public void testToArray() {
        testList = new MyArrayList<>();
        testList.add("one");
        testList.add("two");
        testList.add("three");

        Object [] testArray = testList.toArray();
        assertEquals(3, testArray.length);
        assertEquals("one", testArray[0]);
        assertEquals("two", testArray[1]);

    }

    /**
     * Test method for ToArray(Object[]toHold)
     * @throws NullPointerException
     */
    @Test
    public void testToArrayExistingArray() {
    	testList = new MyArrayList<>();
        testList.add("one");
        testList.add("two");
        testList.add("three");
        
        Object [] testArray = new Object[10];
        testList.toArray(testArray);
        assertEquals("one", testArray[0]);
        assertEquals("two", testArray[1]);
        assertEquals("three", testArray[2]);
        
        
    }

    /**
     * Test method for
     * @throws AssertionError
     */
    @Test
    public void testIterator() {
        testList = new MyArrayList<>();

        testList.add("one");
        testList.add("two");
        testList.add("three");

        utilities.Iterator it = (utilities.Iterator) testList.iterator();
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
        testList = new MyArrayList<>();
        testList.add("one");
        testList.add("two");

        assertThrows(IndexOutOfBoundsException.class, () -> testList.get(4));
    }

    /**
     * Error when trying to remove from an index that is out of bounds
     * @throws IndexOutOfBoundsException
     */
    @Test
    public void testRemoveEmptyList() {
        testList = new MyArrayList<>();
        testList.add("one");
        testList.add("two");
        assertThrows(IndexOutOfBoundsException.class, () ->testList.remove(3));
    }

    /**
     * Error when trying to add a NULL value to an empty list
     * @throws NullPointerException
     */
    @Test
    public void testAddNull() {
        testList = new MyArrayList<>();
        testList.add("one");
        testList.add("two");

        assertThrows(NullPointerException.class, () -> testList.add(null));
    }

    /**
     * Error when trying to add variable that is of the wrong type
     * @throws IllegalArgumentException
     */
    @Test
    public void testDifferentType() {
        testList = new MyArrayList<>();
            testList.add(1);
            assertThrows(IllegalArgumentException.class, () -> testList.add("stuff"));
        
    }
}
