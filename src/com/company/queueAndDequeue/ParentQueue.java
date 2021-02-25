package com.company.queueAndDequeue;

import java.util.LinkedList;

public class ParentQueue<T> extends AbstractParentQueue<T> {
    private int size;
    private final LinkedList<T> storage;
    private int popFirstStatus;
    private int peekFirstStatus;

    public ParentQueue() {
        size = 0;
        storage = new LinkedList<>();

    }


    @Override
    public void pushLast(T value) {
        storage.addLast(value);
        size++;
    }

    @Override
    public void popFirst() {
        if (size > 0) {
            storage.removeFirst();
            size--;
            popFirstStatus = OK;
        } else {
            popFirstStatus = ERR;
        }
    }

    @Override
    public T peekFirst() {
        T value;
        if(size > 0) {
            value = storage.getFirst();
            peekFirstStatus = OK;
        } else {
            value = null;
            peekFirstStatus = ERR;
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getPopFirstStatus() {
        return popFirstStatus;
    }

    @Override
    public int getPeekFirstStatus() {
        return peekFirstStatus;
    }
}
