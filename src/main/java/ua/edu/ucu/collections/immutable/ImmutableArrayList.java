package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] array;
    private int arraySize;

    public ImmutableArrayList(Object[] elements) {
        this.array = Arrays.copyOf(elements, elements.length);
        this.arraySize = array.length;
    }

    public ImmutableArrayList() {
        this.array = new Object[]{};
        this.arraySize = 0;
    }

    @Override
    public String toString() {
        return "ImmutableArrayList{"
                + "array=" + Arrays.toString(array)
                + ", arraySize=" + arraySize
                + '}';
    }

    @Override
    public ImmutableList add(Object e) {
        return add(this.arraySize, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(this.arraySize, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > arraySize) {
            throw new IndexOutOfBoundsException();
        }

        Object[] arrayCopy = new Object[this.arraySize + c.length];

        for (int i = 0; i < index; i++) {
            arrayCopy[i] = this.array[i];
        }

        for (int i = index; i < index + c.length; i++) {
            arrayCopy[i] = c[i - index];
        }

        for (int i = index + c.length; i < arrayCopy.length; i++) {
            arrayCopy[i] = this.array[i - c.length];
        }

        return new ImmutableArrayList(arrayCopy);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index + 1 > this.arraySize) {
            throw new IndexOutOfBoundsException();
        }

        return this.array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] arrayCopy = new Object[this.arraySize - 1];

        for (int i = 0; i < index; i++) {
            arrayCopy[i] = this.array[i];
        }

        for (int i = index; i < arrayCopy.length; i++) {
            arrayCopy[index] = this.array[index + 1];
        }

        return new ImmutableArrayList(arrayCopy);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList arrayList = remove(index);
        return arrayList.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.arraySize; i++) {
            if (this.array[i] == e) {
                return i;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public int size() {
        return this.arraySize;
    }

    @Override
    public ImmutableList clear() {
        Object[] emptyArr = new Object[0];
        return new ImmutableArrayList(emptyArr);
    }

    @Override
    public boolean isEmpty() {
        return this.arraySize == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.array, this.arraySize);
    }
}
