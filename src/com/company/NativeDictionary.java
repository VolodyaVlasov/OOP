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
        storage = (Node<T>[]) new Object[length];
        removeStatus = 0;
        getStatus = 0;
    }

    @Override
    public void put(String key, T value) {
        int index = findBasket(key);
        Node<T> node = new Node<>(key, value, storage[index]);
        size++;
        if (size == length) {
            increaseArray();
        }
    }

    @Override
    public void remove(String key) {
        boolean status = false;
        int index = findBasket(key);
        if (storage[index].key.equals(key)) {
            storage[index] = storage[index].next;
            status = true;
        } else {
            Node<T> start = storage[index].next;
            Node<T> temp = storage[index];
            while (start != null) {
                if (start.key.equals(key)) {
                    temp.next = start.next;
                    status = true;
                    break;
                }
                temp = start;
                start = start.next;
            }
        }
        if (status) {
            size--;
            removeStatus = OK;
        } else {
            removeStatus = ERR;
        }
    }

    @Override
    public T get(String key) {
        T value = null;
        int index = findBasket(key);
        Node<T> start = storage[index];
        while (start != null) {
            if (start.key.equals(key)) {
                value = start.value;
                break;
            }
            start = start.next;
        }
        getStatus = value == null ? ERR : OK;
        return value;
    }

    @Override
    public boolean isKey(String key) {
        boolean answer = false;
        int index = findBasket(key);
        Node<T> start = storage[index];
        while (start != null) {
            if (start.key.equals(key)) {
                answer = true;
                break;
            }
            start = start.next;
        }
        return answer;
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

    private int findBasket(String key) {
        return key.hashCode() % length;
    }

    private void increaseArray() {
        length = length * 3 / 2 + 1;
        Node<T>[] temp = storage;
        storage = (Node<T>[]) new Object[length];
        for (int i = 0; i < temp.length; i++) {
            Node<T> start = temp[i];
            while (start != null) {
                put(start.key, start.value);
                start = start.next;
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
