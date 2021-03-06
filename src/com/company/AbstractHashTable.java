package com.company;

public abstract class AbstractHashTable<T> {
    public static final int NIL = 0; // метод еще не вызывался
    public static final int OK = 1;
    public static final int ERR = 2;

    public static final int ADD_OK = OK;  // значение добавлено
    public static final int ADD_ERR = ERR; // значение не добавлено

    public static final int REMOVE_OK = OK;  // значение удалено
    public static final int REMOVE_ERR = ERR; // значение отсутствует


    //команды:

    //предусловие: для элемента найдено место
    //постусловие: элемент добавлен
    public abstract void add(final T value);

    //постусловие: элемент удален
    public abstract void remove(final T value);

    //запросы:

    public abstract boolean check(final T value);

    public abstract int size();

    //дополнительные запросы:
    public abstract int getAddStatus();

    public abstract int getRemoveStatus();
}
