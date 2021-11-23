package com.company;

public abstract class Laboratory implements Classroom, Info{
    public int number;
    public int floor;
    public float square;

    public Laboratory(int number, int floor, float square) {
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

    @Override
    public int calcCapacity(){
        return 10;
    }
}
