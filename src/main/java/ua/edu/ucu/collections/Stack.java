package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList linkedLst;

    public Stack() {
        this.linkedLst = new ImmutableLinkedList();
    }

    @Override
    public String toString() {
        return "Stack{"
                + "linkedLst=" + linkedLst
                + '}';
    }

    public void push(Object e) {
        this.linkedLst = linkedLst.addFirst(e);
    }

    public Object pop() {
        Object el = peek();
        this.linkedLst = linkedLst.removeFirst();
        return el;
    }

    public Object peek() {
        return linkedLst.getFirst();
    }
}
