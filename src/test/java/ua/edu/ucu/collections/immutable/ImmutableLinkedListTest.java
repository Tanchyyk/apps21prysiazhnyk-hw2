package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import java.util.Arrays;

public class ImmutableLinkedListTest extends TestCase {
    Object[] arr0 = {1, 2, 3, 4};
    Object[] arr1 = {5, 6};
    Object o1 = 10;
    ImmutableLinkedList a1 = new ImmutableLinkedList(arr0);

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testToString() {
        assertEquals(a1.toString(), "ImmutableLinkedList{head=1, tail=4, size=4}");
    }

    public void testAdd() {
        assertEquals(a1.add(o1).toString(), "ImmutableLinkedList{head=1, tail=[Ljava.lang.Object;@9660f4e, size=5}");
    }

    public void testTestAdd() {
        assertEquals(a1.add(2, arr1).toString(), "ImmutableLinkedList{head=1, tail=4, size=5}");
    }

    public void testAddAll() {
        assertEquals(a1.addAll(arr1).toString(), "ImmutableLinkedList{head=1, tail=6, size=6}");
    }

    public void testTestAddAll() {
        assertEquals(a1.addAll(2, arr1).toString(), "ImmutableLinkedList{head=1, tail=4, size=6}");
    }

    public void testGet() {
        assertEquals(a1.get(2), 3);
    }

    public void testRemove() {
        assertEquals(a1.remove(2).toString(), "ImmutableLinkedList{head=1, tail=4, size=3}");
    }

    public void testSet() {
        assertEquals(a1.set(3, o1).toString(), "ImmutableLinkedList{head=1, tail=10, size=4}");
    }

    public void testIndexOf() {
        assertEquals(a1.indexOf(1), 0);
    }

    public void testSize() {
        assertEquals(a1.size(), 4);
    }

    public void testIsEmpty() {
        assertFalse(a1.isEmpty());
    }

    public void testToArray() {
        assertEquals(Arrays.toString(a1.toArray()), "[1, 2, 3, 4]");
    }

    public void testAddFirst() {
        assertEquals(a1.addFirst(o1).toString(), "ImmutableLinkedList{head=10, tail=4, size=5}");
    }

    public void testAddLast() {
        assertEquals(a1.addLast(o1).toString(), "ImmutableLinkedList{head=1, tail=10, size=5}");
    }
}