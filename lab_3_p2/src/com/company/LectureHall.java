package com.company;

public class LectureHall implements Classroom, Info{
    public int row;
    public int seat;
    public boolean projector;

    public LectureHall(int row, int seat, boolean projector) {
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
        if (projector)
            proj = "Есть";
        else
            proj = "Нет";
        System.out.println("\nЛекционная аудитория:\nКоличество рядов - " + getRow() +
                "\nКоличество посадочных мест в ряду - "+ getSeat() + "\nНаличие проектора - " + proj);
    }
}
