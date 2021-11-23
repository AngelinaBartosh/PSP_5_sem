package com.company;

public abstract class Classroom implements Info, Room {
    public int number;
    public int floor;
    public float square;

    public Classroom(int number, int floor, float square) {
        this.number = number;
        this.floor = floor;
        this.square = square;
    }

    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public float getSquare() {
        return square;
    }

    public int calcCapacity (){
        return 30;
    }
}
