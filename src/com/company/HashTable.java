package com.company;

public class HashTable<T> extends AbstractHashTable<T> {
    private int size;
    private T[] storage;
    private int addStatus;

    public HashTable(int size) {
        this.size = size;
        storage = (T[]) new Object[size];
    }

    @Override
    public void add(final T value) {
        int index = find(value);
        if (storage[index] == null) {
            storage[index] = value;
            addStatus = OK;
        } else {
            addStatus = ERR;
        }
    }

    @Override
    public void remove(final T value) {
        int index = find(value);
        if (storage[index] != null && storage[index].equals(value)) {
            storage[index] = null;
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
