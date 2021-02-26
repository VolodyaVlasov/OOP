package com.company;

public class HashTable<T> extends AbstractHashTable<T> {
    private int size;
    private T[] storage;
    private int addStatus;

    public HashTable(int length) {
        size = 0;
        storage = (T[]) new Object[length];
    }

    @Override
    public void add(final T value) {
        int index = find(value);
        if (storage[index] == null) {
            storage[index] = value;
            addStatus = OK;
            size++;
        } else {
            addStatus = ERR;
        }
    }

    @Override
    public void remove(final T value) {
        int index = find(value);
        if (storage[index] != null && storage[index].equals(value)) {
            storage[index] = null;
            size--;
        }
    }

    @Override
    public boolean check(final T value) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getAddStatus() {
        return addStatus;
    }

    private int find(T value) {
        return value.hashCode() % size;
    }
}
