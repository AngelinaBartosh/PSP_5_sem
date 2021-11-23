package com.company;

public class EducateClass extends Classroom {
    public int countDesk;
    public boolean computer;

    public int getCountDesk() {
        return countDesk;
    }

    public boolean isComputer() {
        return computer;
    }

    public EducateClass(int number, int floor, float square, int countDesk, boolean computer) {
        super(number, floor, square);
        this.countDesk = countDesk;
        this.computer = computer;
    }

    @Override
    public int calcCapacity(){
        return getCountDesk() * 2;
    }

    @Override
    public void printInfo(){
        String comp;
        if(isComputer())
            comp = "Есть";
        else
            comp = "Нет";
        System.out.println("\nУчебный класс:\nНомер - " + getNumber() + "\nЭтаж - "  + getFloor() +
                "\nПлощадь - " + getSquare() + "\nКоличество парт - " + getCountDesk() + "\nКомпьютер - " + comp);
    }
}
