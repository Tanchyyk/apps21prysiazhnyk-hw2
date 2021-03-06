package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedLst;

    public Queue() {
        this.linkedLst = new ImmutableLinkedList();
    }

    @Override
    public String toString() {
        return "Queue{"
                + "linkedLst=" + linkedLst
                + '}';
    }

    public Object peek() {
        return linkedLst.getFirst();
    }

    public Object dequeue() {
        Object res = peek();
        this.linkedLst = linkedLst.removeFirst();
        return res;
    }

    public void enqueue(Object e) {
        this.linkedLst = linkedLst.addLast(e);
    }
}
