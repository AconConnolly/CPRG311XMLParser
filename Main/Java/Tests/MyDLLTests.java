package Tests;

import Type.DoublyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyDLLTests {
    private DoublyLinkedList dll;

    @Test
    public void setUp() throws Exception {
        dll = new DoublyLinkedList();
    }

    @Test
    public void createNewNode() throws Exception {
        int sizeBefore = dll.size();

        dll.addNode(1);
        dll.addNode(2);

        assertEquals(sizeBefore + 2, dll.size());
    }

    @Test
    public void addToHead() throws Exception {
        dll.addNode(1);
        dll.addNode(2);

        dll.addIntoHead(0);

        assertEquals(0, dll.returnHead());
    }

}