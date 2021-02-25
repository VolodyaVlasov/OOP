package com.company;

import java.util.Arrays;

public class DynArray<T> extends AbstractDynArray<T> {
    private int size;
    private int capacity;
    private T[] array;
    private int addByIndexStatus;
    private int replaceStatus;
    private int removeStatus;
    private int findStatus;
    private int getByIndexStatus;

    public DynArray() {
        this(16);
    }

    public DynArray(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        addByIndexStatus = 0;
        replaceStatus = 0;
        removeStatus = 0;
        findStatus = 0;
        getByIndexStatus = 0;
    }

    @Override
    public void addByIndex(T value, int index) {
        if (index > size) {
            addByIndexStatus = ERR;
        } else {
            if (capacity == size) {
                increaseArray();
            }
            if (index != size) {
                System.arraycopy(array, index, array, index + 1, size - index);
                ;
            }
            array[index] = value;
            size++;
            addByIndexStatus = OK;
        }
    }

    @Override
    public void replace(T value, int index) {
        if (index < size) {
            array[index] = value;
            replaceStatus = OK;
        } else {
            replaceStatus = ERR;
        }
    }

    @Override
    public void remove(int index) {
        if (index >= size) {
            removeStatus = ERR;
        } else {
            if (index != size - 1) {
                System.arraycopy(array, index + 1, array, index, size - index);
            }
            array[size - 1] = null;
            size--;
            removeStatus = OK;
            if (size < capacity / 1.5) {
                reduceArray();
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int find(T value) {
        int index = -1;
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    index = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(array[i])) {
                    index = i;
                    break;
                }
            }
        }
        findStatus = index == -1 ? ERR : OK;
        return index;
    }

    @Override
    public T getByIndex(int index) {
        T value;
        if (index < size) {
            value = array[index];
            getByIndexStatus = OK;
        } else {
            value = null;
            getByIndexStatus = ERR;
        }
        return value;
    }

    @Override
    public int getAddByIndexStatus() {
        return addByIndexStatus;
    }

    @Override
    public int getReplaceStatus() {
        return replaceStatus;
    }

    @Override
    public int getRemoveStatus() {
        return removeStatus;
    }

    @Override
    public int getFindStatus() {
        return findStatus;
    }

    @Override
    public int getGetByIndexStatus() {
        return getByIndexStatus;
    }

    private void increaseArray() {
        capacity = capacity * 3 / 2 + 1;
        array = Arrays.copyOf(array, capacity);
    }

    private void reduceArray() {
        if (capacity / 1.5 > 16) {
            capacity = (int) (capacity / 1.5);
            array = Arrays.copyOf(array, capacity);
        }
    }
}
