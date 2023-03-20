package Tests;

import Type.DoublyLinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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

    @Test
    public void isEmpty() {
        assert dll.size() == 0;
    }

}