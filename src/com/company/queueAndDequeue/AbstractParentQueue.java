package com.company.queueAndDequeue;

public abstract class AbstractParentQueue<T> {
    public static final int NIL = 0; // метод еще не вызылся
    public static final int OK = 1;
    public static final int ERR = 2;

    public static final int POP_FIRST_OK = OK;  // последняя pop() отработала нормально
    public static final int POP_FIRST_ERR = ERR; // очередь пустая

    public static final int PEEK_FIRST_OK = OK;  // последняя peek() вернула корректное значение
    public static final int PEEK_FIRST_ERR = ERR; // очередь пустая

    // конструктор
    public AbstractParentQueue() {
    }

    // команды:

    // постусловие: элемент добавлен в конец очереди
    public abstract void pushLast(T value);

    // предусловие: очередь не пустая
    // постусловие: элемент удален с начала очереди
    public abstract void popFirst();

    // запросы:

    // предусловие: очередь не пустая
    public abstract T peekFirst();

    public abstract int size();

    // дополнительные запросы
    public abstract int getPopFirstStatus();

    public abstract int getPeekFirstStatus();

}
