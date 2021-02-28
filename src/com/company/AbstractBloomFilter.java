package com.company;

public abstract class AbstractBloomFilter<T> {
    //конструктор:
    // public BloomFilter(int size);

    //команды:

    //постусловие: добавленно новое значение в фильтр
    public abstract void add(T value);

    //запросы:
    public abstract void isValue(T value);
}
