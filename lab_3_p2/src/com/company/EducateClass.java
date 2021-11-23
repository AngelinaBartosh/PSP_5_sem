package com.company;

public class EducateClass implements Classroom, Info {
    public int countDesk;
    public boolean computer;

    public int getCountDesk() {
        return countDesk;
    }

    public boolean isComputer() {
        return computer;
    }

    public EducateClass(int countDesk, boolean computer) {
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
        if(computer)
            comp = "Есть";
        else
            comp = "Нет";
        System.out.println("\nУчебный класс:\nКоличество парт - " + getCountDesk() + "\nКомпьютер - " + comp +
                "\nКоличество мест - " + calcCapacity());
    }
}
