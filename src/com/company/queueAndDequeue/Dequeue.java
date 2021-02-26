package com.company.queueAndDequeue;

import java.util.LinkedList;

public class Dequeue<T> extends ParentQueue<T> {
    private int popLastStatus;
    private int peekLastStatus;

    public Dequeue() {
        this.popLastStatus = NIL;
        this.peekLastStatus = NIL;
    }

    public void pushFirst(T value) {
        storage.addFirst(value);
        size++;
    }

    public void popLast() {
        if (size > 0) {
            storage.removeLast();
            size--;
            popLastStatus = OK;
        } else {
            popLastStatus = ERR;
        }
    }

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

    public int getPopLastStatus() {
        return popLastStatus;
    }

    public int getPeekLastStatus() {
        return peekLastStatus;
    }
}
