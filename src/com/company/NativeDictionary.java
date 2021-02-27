package com.company;

public class NativeDictionary<T> extends AbstractNativeDictionary<T> {
    private int size;
    private Node<T>[] storage;
    private int length;
    private int removeStatus;
    private int getStatus;

    public NativeDictionary() {
        this(16);
    }

    public NativeDictionary(int length) {
        size = 0;
        this.length = length;
        storage = new Node[length];
        removeStatus = NIL;
        getStatus = NIL;
    }

    @Override
    public void put(String key, T value) {
        int index = findBasket(key);
        storage[index] = new Node<>(key, value, storage[index]);
        size++;
        if (size > length) {
            increaseArray();
        }
    }

    @Override
    public void remove(String key) {
        int index = findBasket(key);
        boolean status = false;
        if (storage[index] != null) {
            if (storage[index].key.equals(key)) {
                storage[index] = storage[index].next;
                size--;
                status = true;
            } else {
                Node<T> start = storage[index].next;
                Node<T> prev = storage[index];
                while (start != null) {
                    if (start.key.equals(key)) {
                        prev.next = start.next;
                        size--;
                        status = true;
                        break;
                    }
                    prev = start;
                    start = start.next;
                }
            }
        }
        removeStatus = status ? OK : ERR;
    }

    @Override
    public T get(String key) {
        int index = findBasket(key);
        Node<T> start = storage[index];
        while (start != null) {
            if (start.key.equals(key)) {
                getStatus = OK;
                return start.value;
            }
            start = start.next;
        }
        getStatus = ERR;
        return null;
    }

    @Override
    public boolean isKey(String key) {
        int index = findBasket(key);
        Node<T> start = storage[index];
        while (start != null) {
            if (start.key.equals(key)) {
                return true;
            }
            start = start.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getRemoveStatus() {
        return removeStatus;
    }

    @Override
    public int getGetStatus() {
        return getStatus;
    }

    public int findBasket(String key) {
        return key.hashCode() % length;
    }

    private void increaseArray() {
        length = length * 3 / 2 + 1;
        Node<T>[] temp = storage;
        storage = new Node[length];
        for (Node<T> node : temp) {
            if (node != null) {
                Node<T> start = node;
                while (start != null) {
                    put(start.key, start.value);
                    start = start.next;
                }
            }
        }
    }


    private static class Node<T> {
        String key;
        T value;
        Node<T> next;

        public Node(String key, T value, Node<T> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}