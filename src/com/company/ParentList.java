package com.company;

public class ParentList<T> {
    public static final int NIL = 0;
    public static final int OK = 1;
    public static final int ERR = 2;

    protected Node<T> firstInList;
    protected Node<T> lastInList;
    protected Node<T> cursor;
    protected int size;
    protected int headStatus;
    protected int tailStatus;
    protected int rightStatus;
    protected int putRightStatus;
    protected int putLeftStatus;
    protected int removeStatus;
    protected int replaceStatus;
    protected int findStatus;
    protected int getStatus;

    public ParentList() {
        firstInList = null;
        lastInList = null;
        cursor = null;
        this.size = 0;
        headStatus = NIL;
        tailStatus = NIL;
        rightStatus = NIL;
        putRightStatus = NIL;
        putLeftStatus = NIL;
        removeStatus = NIL;
        replaceStatus = NIL;
        findStatus = NIL;
        getStatus = NIL;
    }

    public void head() {
        if (firstInList == null) {
            headStatus = ERR;
        } else {
            cursor = firstInList;
            headStatus = OK;
        }
    }

    public void tail() {
        if (lastInList == null) {
            tailStatus = ERR;
        } else {
            cursor = lastInList;
            tailStatus = OK;
        }
    }

    public void right() {
        if (cursor != null && cursor != lastInList) {
            cursor = cursor.right;
            rightStatus = OK;
        } else {
            rightStatus = ERR;
        }
    }

    public void putRight(T value) {
        if (cursor != null) {
            Node<T> node = new Node<>(value, cursor, cursor.right);
            cursor.right = node;
            if (node.right == null) {
                lastInList = node;
            } else {
                node.right.left = node;
            }
            size++;
            putRightStatus = OK;
        } else {
            putRightStatus = ERR;
        }
    }

    public void putLeft(T value) {
        if (cursor != null) {
            Node<T> node = new Node<>(value, cursor.left, cursor);
            cursor.left = node;
            if (node.left == null) {
                firstInList = node;
            } else {
                node.left.right = node;
            }
            size++;
            putLeftStatus = OK;
        } else {
            putLeftStatus = ERR;
        }
    }

    public void remove() {
        if (cursor != null) {
            Node<T> temp = cursor.right == null ? cursor.left : cursor.right;
            if (cursor.right != null) {
                cursor.right.left = cursor.left;
            } else {
                lastInList = cursor.left;
            }
            if (cursor.left != null) {
                cursor.left.right = cursor.right;
            } else {
                firstInList = cursor.right;
            }
            cursor = temp;
            size--;
            removeStatus = OK;
        } else {
            removeStatus = ERR;
        }
    }

    public void clear() {
        firstInList = null;
        lastInList = null;
        size = 0;
    }

    public void addTail(T value) {
        Node<T> node = new Node<>(value, lastInList, null);
        if (lastInList == null) {
            lastInList = node;
            firstInList = node;
        } else {
            lastInList.right = node;
            lastInList = node;
        }
        size++;
    }

    public void replace(T value) {
        if (cursor != null) {
            cursor.value = value;
            replaceStatus = OK;
        } else {
            replaceStatus = ERR;
        }
    }

    public void find(T value) {
        Node<T> node = firstInList;
        boolean status = false;
        if (value == null) {
            while (node != null) {
                if (node.value == null) {
                    status = true;
                    break;
                }
                node = node.right;
            }
        } else {
            while (node != null) {
                if (value.equals(node.value)) {
                    status = true;
                    break;
                }
                node = node.right;
            }
        }
        if (status) {
            cursor = node;
            findStatus = OK;
        } else {
            findStatus = ERR;
        }
    }

    public void removeAll(T value) {
        find(value);
        while (findStatus == OK) {
            remove();
            find(value);
        }
    }

    public T get() {
        T value;
        if (cursor != null) {
            value = cursor.value;
            getStatus = OK;
        } else {
            value = null;
            getStatus = ERR;
        }
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isHead() {
        return cursor == firstInList;
    }

    public boolean isTail() {
        return cursor == lastInList;
    }

    public boolean isValue() {
        return cursor != null;
    }

    public int getHeadStatus() {
        return headStatus;
    }

    public int getTailStatus() {
        return tailStatus;
    }

    public int getRightStatus() {
        return rightStatus;
    }

    public int getPutRightStatus() {
        return putRightStatus;
    }

    public int getPutLeftStatus() {
        return putLeftStatus;
    }

    public int getRemoveStatus() {
        return removeStatus;
    }

    public int getReplaceStatus() {
        return replaceStatus;
    }

    public int getFindStatus() {
        return findStatus;
    }

    public int getGetStatus() {
        return getStatus;
    }


    protected static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
