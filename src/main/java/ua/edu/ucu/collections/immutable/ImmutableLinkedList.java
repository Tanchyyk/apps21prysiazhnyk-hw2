package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private final int size;

    public ImmutableLinkedList(Object[] elements) {
        this.size = elements.length;
        Node currNode = null;

        for (int i = 0; i < elements.length; i++) {
            Node nextNode = new Node(elements[i]);
            if (currNode != null) {
                currNode.setNext(nextNode);
            }

            nextNode.setPrevious(currNode);
            currNode = nextNode;

            if (i == 0) {
                this.head = nextNode;
            }

            if (i == elements.length - 1) {
                this.tail = nextNode;
            }
        }

    }

    public ImmutableLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public String toString() {
        return "ImmutableLinkedList{"
                + "head=" + head
                + ", tail=" + tail
                + ", size=" + size
                + '}';
    }

    @Override
    public ImmutableList add(Object e) {
        return add(this.size, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(this.size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] array = Arrays.copyOf(this.toArray(), this.size);
        Object[] arrayCopy = new Object[this.size + c.length];

        for (int i = 0; i < index; i++) {
            arrayCopy[i] = array[i];
        }

        for (int i = index; i < index + c.length; i++) {
            arrayCopy[i] = c[i - index];
        }

        for (int i = index + c.length; i < arrayCopy.length; i++) {
            arrayCopy[i] = array[i - c.length];
        }

        return new ImmutableLinkedList(arrayCopy);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node currNode = this.head;
        int currIdx = 0;
        while (currNode != null) {
            if (currIdx == index) {
                return currNode.getValue();
            }
            currNode = currNode.getNext();
            currIdx++;
        }
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] currentList = Arrays.copyOf(this.toArray(), this.size);
        Object[] newList = new Object[this.size - 1];
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                continue;
            }
            newList[count++] = currentList[i];
        }
        return new ImmutableLinkedList(newList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList linkedList = this.remove(index);
        return linkedList.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        Node currNode = this.head;
        int count = 0;
        while (currNode != null) {
            if (currNode.getValue() == e) {
                return count;
            }

            count++;
            currNode = currNode.getNext();
        }
        return 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableList clear() {
        Object[] array = new Object[this.size];
        return new ImmutableLinkedList(array);
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        Node currNode = this.head;

        for (int i = 0; i < this.size; i++) {
            array[i] = currNode.getValue();
            currNode = currNode.getNext();
        }

        return array;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] currList = Arrays.copyOf(this.toArray(), this.size);
        Object[] newList = new Object[this.size + 1];
        newList[0] = e;
        System.arraycopy(currList, 0, newList, 1, this.size);
        return new ImmutableLinkedList(newList);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] currList = Arrays.copyOf(this.toArray(), this.size);
        Object[] newList = new Object[this.size + 1];
        newList[this.size] = e;
        System.arraycopy(currList, 0, newList, 0, this.size);
        return new ImmutableLinkedList(newList);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        return head.getValue();
    }

    public Object getLast() {
        if (tail == null) {
            throw new IndexOutOfBoundsException();
        }
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] array = Arrays.copyOfRange(this.toArray(), 1, this.size);
        return new ImmutableLinkedList(array);
    }

    public ImmutableLinkedList removeLast() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] array = Arrays.copyOf(this.toArray(), size - 1);
        return new ImmutableLinkedList(array);
    }
}
