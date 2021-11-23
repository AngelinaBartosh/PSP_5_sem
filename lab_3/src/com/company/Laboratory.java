package com.company;

public class Laboratory extends Classroom {
    public int countComputer;

    public Laboratory(int number, int floor, float square, int countComputer) {
        super(number, floor, square);
        this.countComputer = countComputer;
    }

    public int getCountComputer() {
        return countComputer;
    }

    @Override
    public int calcCapacity(){
        return 15;
    }

    @Override
    public void printInfo(){
        System.out.println("\nЛаборатория:\nНомер - " + getNumber() + "\nЭтаж - " + getFloor() + "\nПлощадь - "
                + getSquare() + "\nВместимость - " + calcCapacity() + "\nКоличество компьютеров - " + getCountComputer());
    }
}
