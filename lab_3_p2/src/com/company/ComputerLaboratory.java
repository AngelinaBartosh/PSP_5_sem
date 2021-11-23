package com.company;

public class ComputerLaboratory extends Laboratory {
    public int countComputer;
    public int countDesk;
    public int seat;

    public ComputerLaboratory(int number, int floor, float square, int countComputer, int countDesk, int seat) {
        super(number, floor, square);
        this.countComputer = countComputer;
        this.countDesk = countDesk;
        this.seat = seat;
    }

    public int getCountComputer() {
        return countComputer;
    }

    public int getCountDesk() {
        return countDesk;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public int calcCapacity(){
        return getSeat();
    }

    @Override
    public void printInfo(){
        System.out.println("\nКомпьютерная лаборатория:\nНомер - " + getNumber() + "\nЭтаж - " +
                getFloor() + "\nПлощадь - " + getSquare() + "\nКоличество парт - " + getCountDesk() +
                "\nКоличество посадочных мест - "+ getSeat() + "\nКоличество компьютеров - " + getCountComputer());

    }

}
