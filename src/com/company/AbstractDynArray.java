package com.company;

public abstract class AbstractDynArray<T> {
    public static final int NIL = 0; // метод еще не вызывался
    public static final int OK = 1;
    public static final int ERR = 2;

    public static final int ADD_BY_INDEX_OK = OK;   // значение добавлено
    public static final int ADD_BY_INDEX_ERR = ERR; // индекс за пределами массива

    public static final int REPLACE_OK = OK;   // значение заменено
    public static final int REPLACE_ERR = ERR; // индекс за пределами массива

    public static final int REMOVE_OK = OK;   // значение удалено
    public static final int REMOVE_ERR = ERR; // индекс за пределами массива

    public static final int FIND_OK = OK;   // значение найдено
    public static final int FIND_ERR = ERR; // значение не неайдено

    public static final int GET_BY_INDEX_OK = OK;   // метод вернет значение по индексу
    public static final int GET_BY_INDEX_ERR = ERR; // индекс за пределами массива

    //конструктор
    //public AbstractDynArray<T> AbstractDynArray();

    //Команды

    //Постусловие: элемент добавлен в конец массива
    public abstract void append();

    //Предусловие: индекс не находится за пределами массива
    //Постусловие: элемент добавлен по указанному индексу, элементы сдвигаются вправо
    public abstract void addByIndex(int index);

    //Предусловие: индекс не находится за пределами массива
    //Постусловие: заменен элемент по указанному индексу
    public abstract void replace(int index);

    //Предусловие: индекс не находится за пределами массива
    //Постусловие: удален элемент по указанному индексу, элементы сдигаются влево
    public abstract void remove(int index);

    //Запросы

    public abstract int size();

    //Предусловие: элемент имеется в массиве
    public abstract int find(T value);

    //Предусловие: индекс не находится за пределами массива
    public abstract T getByIndex(int index);

    //Дополнительные запросы
    public abstract int getAddByIndexStatus();

    public abstract int getReplaceStatus();

    public abstract int getRemoveStatus();

    public abstract int getFindStatus();

    public abstract int getGetByIndexStatus();
}
