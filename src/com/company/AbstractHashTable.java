package com.company;

public abstract class AbstractHashTable<T> {
    //команды:

    //предусловие: для элемента найдено место
    //постусловие: элемент добавлен
    public abstract void add(T value);

    //постусловие: элемент удален
    public abstract void remove(T value);

    //запросы:

    public abstract boolean check(T value);

    //дополнительные запросы:
    public abstract int getAddStatus();
}
