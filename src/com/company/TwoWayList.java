package com.company;

public class TwoWayList<T> extends ParentList<T> {
    private int leftStatus;

    public void left() {
        if (cursor != null && cursor != firstInList) {
            cursor = cursor.left;
            leftStatus = OK;
        } else {
            leftStatus = ERR;
        }
    }

    private int getLeftStatus() {
        return leftStatus;
    }
}
