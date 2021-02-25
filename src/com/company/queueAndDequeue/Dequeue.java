package com.company.queueAndDequeue;

import java.util.LinkedList;

public class Dequeue<T> extends AbstractDequeue<T> {
    private int size;
    private final LinkedList<T> storage;
    private int popFirstStatus;
    private int peekFirstStatus;
    private int popLastStatus;
    private int peekLastStatus;

    public Dequeue() {
        this.size = NIL;
        this.storage = new LinkedList<>();
        this.popFirstStatus = NIL;
        this.peekFirstStatus = NIL;
        this.popLastStatus = NIL;
        this.peekLastStatus = NIL;
    }


    @Override
    public void pushFirst(T value) {
        storage.addFirst(value);
        size++;
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
    public void popLast() {
        if (size > 0) {
            storage.removeLast();
            size--;
            popLastStatus = OK;
        } else {
            popLastStatus = ERR;
        }
    }

    @Override
    public T peekFirst() {
        T value;
        if (size > 0) {
            value = storage.getFirst();
            peekFirstStatus = OK;
        } else {
            value = null;
            peekFirstStatus = ERR;
        }
        return value;
    }

    @Override
    public T peekLast() {
        T value;
        if (size > 0) {
            value = storage.getLast();
            peekLastStatus = OK;
        } else {
            value = null;
            peekLastStatus = ERR;
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
    public int getPopLastStatus() {
        return popLastStatus;
    }

    @Override
    public int getPeekFirstStatus() {
        return peekFirstStatus;
    }

    @Override
    public int getPeekLastStatus() {
        return peekLastStatus;
    }
}
