package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import java.util.Arrays;

public class ImmutableArrayListTest extends TestCase {
    Object[] arr0 = {1, 2, 3, 4};
    Object[] arr1 = {5, 6};
    Object o1 = 10;
    ImmutableArrayList a1 = new ImmutableArrayList(arr0);

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testToString() {
        assertEquals(a1.toString(), "ImmutableArrayList{array=[1, 2, 3, 4], arraySize=4}");
    }

    public void testAdd() {
        assertEquals(a1.add(o1).toString(), "ImmutableArrayList{array=[1, 2, 3, 4, 10], arraySize=5}");
    }

    public void testTestAdd() {
        assertEquals(a1.add(2, arr1).size(), 1 + a1.size());
    }

    public void testAddAll() {
        assertEquals(a1.addAll(arr1).toString(), "ImmutableArrayList{array=[1, 2, 3, 4, 5, 6], arraySize=6}");
    }

    public void testTestAddAll() {
        assertEquals(a1.addAll(2, arr1).toString(), "ImmutableArrayList{array=[1, 2, 5, 6, 3, 4], arraySize=6}");
    }

    public void testGet() {
        assertEquals(a1.get(0), 1);
    }

    public void testRemove() {
        assertEquals(a1.remove(3).toString(), "ImmutableArrayList{array=[1, 2, 3], arraySize=3}");
    }

    public void testSet() {
        assertEquals(a1.set(3, o1).toString(), "ImmutableArrayList{array=[1, 2, 3, 10], arraySize=4}");
    }

    public void testIndexOf() {
        assertEquals(a1.indexOf(2), 1);
    }

    public void testSize() {
        assertEquals(a1.size(), 4);
    }

    public void testClear() {
        assertEquals(a1.clear().toString(), "ImmutableArrayList{array=[], arraySize=0}");
    }

    public void testIsEmpty() {
        assertFalse(a1.isEmpty());
    }

    public void testToArray() {
        assertEquals(Arrays.toString(a1.toArray()), "[1, 2, 3, 4]");
    }
}
