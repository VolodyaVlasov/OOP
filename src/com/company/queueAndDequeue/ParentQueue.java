package com.company.queueAndDequeue;

import java.util.LinkedList;

public  class ParentQueue<T>  {
    public static final int NIL = 0; // метод еще не вызылся
    public static final int OK = 1;
    public static final int ERR = 2;

    public static final int POP_FIRST_OK = OK;  // последняя popFirst отработала нормально
    public static final int POP_FIRST_ERR = ERR; // очередь пустая

    public static final int PEEK_FIRST_OK = OK;  // последняя peekFirst вернула корректное значение
    public static final int PEEK_FIRST_ERR = ERR; // очередь пустая

    protected int size;
    protected final LinkedList<T> storage;
    protected int popFirstStatus;
    protected int peekFirstStatus;

    public ParentQueue() {
        size = 0;
        storage = new LinkedList<>();
        popFirstStatus = NIL;
        peekFirstStatus = NIL;
    }

    public void pushLast(T value) {
        storage.addLast(value);
        size++;
    }

    public void popFirst() {
        if (size > 0) {
            storage.removeFirst();
            size--;
            popFirstStatus = OK;
        } else {
            popFirstStatus = ERR;
        }
    }

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

    public int size() {
        return size;
    }

    public int getPopFirstStatus() {
        return popFirstStatus;
    }

    public int getPeekFirstStatus() {
        return peekFirstStatus;
    }
}
