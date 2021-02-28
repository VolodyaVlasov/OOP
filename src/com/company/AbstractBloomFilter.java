package com.company;

public abstract class AbstractBloomFilter<T> {
    //команды:
    public abstract void add(T value);

    //запросы:
    public abstract void isValue(T value);


}
