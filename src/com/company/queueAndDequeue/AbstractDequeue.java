package com.company.queueAndDequeue;

public abstract class AbstractDequeue<T> extends AbstractParentQueue<T> {
    public static final int POP_LAST_OK = OK;  // последняя popLast отработала нормально
    public static final int POP_LAST_ERR = ERR; // очередь пустая

    public static final int PEEK_LAST_OK = OK;  // последняя peekLast вернула корректное значение
    public static final int PEEK_LAST_ERR = ERR; // очередь пустая



    //конструктор:
    public AbstractDequeue(){}

    //команды:

    // постусловие: элемент добавлен в начало очереди
    public abstract void pushFirst(T value);

    // предусловие: очередь не пустая
    // постусловие: элемент удален с конца очереди
    public abstract void popLast();

    //запросы:

    // предусловие: очередь не пустая
    public abstract T peekLast();

    // дополнительные запросы
    public abstract int getPopLastStatus();

    public abstract int getPeekLastStatus();
}
