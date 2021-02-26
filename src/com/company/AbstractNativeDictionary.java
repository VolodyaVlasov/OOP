package com.company;

public abstract class AbstractNativeDictionary<T> {
    public static final int NIL = 0; // метод еще не вызылся
    public static final int OK = 1;
    public static final int ERR = 2;

    public static final int REMOVE_OK = OK;  // пара удалена
    public static final int REMOVE_ERR = ERR; // ключ отсутствует

    public static final int GET_OK = OK;  // метод вернет значение
    public static final int GET_ERR = ERR; // ключ отсутствует

    //команды:

    //постусловие: добавлена новая пара ключ/значение
    public abstract void put(String key, T value);

    //предусловие: ключ имеется в таблице
    //постусловие: пара ключ/значение удалена
    public abstract void remove(String key);

    //запросы:

    //предусловие: ключ имеется в таблице
    public abstract T get(String key);

    public abstract boolean isKey(String key);

    public abstract int size();

    //дополнительные запросы

    public abstract int getRemoveStatus();

    public abstract int getGetStatus();
}
