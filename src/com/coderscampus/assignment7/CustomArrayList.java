package com.coderscampus.assignment7;

public class CustomArrayList<T> implements CustomList<T> {

    Object[] items = new Object[10];
    int arraySize = 0;

    @Override
    public boolean add(T item) {
        return add(arraySize, item);
    }

    @Override
    public boolean add(int index, T item) throws IndexOutOfBoundsException {

        if (index > arraySize) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }


        if (arraySize >= items.length) {
            items = increaseArraySize();
        }

        for (int i = arraySize-1; i>index; i--) {
            items[i+1] = items[i];
        }
        items[index] = item;
        arraySize++;
        return true;
    }

    @Override
    public int getSize() {
        return arraySize;
    }

    @Override
    public T get(int index) {
        return (T) items[index];

    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index >= arraySize) {
            throw new IndexOutOfBoundsException();
        }
        T removedItem = (T) items[index];

        for (int i = index; i<arraySize-1; i++) {
            items[i] = items[i+1];
        }
        arraySize--;
        return removedItem;
    }

    private Object[] increaseArraySize() {
        Object[] newItemsArray = new Object[arraySize*2];
        for (int i = 0; i < arraySize; i++) {
            newItemsArray[i] = items[i];
        }
        return newItemsArray;
    }
}
