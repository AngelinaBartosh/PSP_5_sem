package com.company;

public class LectureHall extends Classroom{
    public int row;
    public int seat;
    public boolean projector;

    public LectureHall(int number, int floor, float square, int row, int seat, boolean projector) {
        super(number, floor, square);
        this.row = row;
        this.seat = seat;
        this.projector = projector;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public boolean isProjector() {
        return projector;
    }

    @Override
    public int calcCapacity(){
        return getSeat();
    }

    @Override
    public void printInfo(){
        String proj;
        if (isProjector())
            proj = "Есть";
        else
            proj = "Нет";
        System.out.println("\nЛекционная аудитория:\nНомер - " + getNumber() + "\nЭтаж - " +
                getFloor() + "\nПлощадь - " + getSquare() + "\nКоличество рядов - " + getRow() +
                "\nКоличество посадочных мест в ряду - "+ getSeat() + "\nНаличие проектора - " + proj);
    }
}
