package codelab01.busses;

import codelab01.DriveAble;

import java.util.UUID;

public abstract class Bus implements DriveAble {
    private UUID id;
    private int capacity;
    private double cost;

    public Bus(int capacity, double cost) {
        id = UUID.randomUUID();
        this.capacity = capacity;
        this.cost = cost;
    }
}
