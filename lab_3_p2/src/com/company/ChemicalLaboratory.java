package com.company;

public class ChemicalLaboratory extends Laboratory {
    public int countSubstance;
    public int countInstrument;

    public int getCountSubstance() {
        return countSubstance;
    }

    public int getCountInstrument() {
        return countInstrument;
    }

    public ChemicalLaboratory(int number, int floor, float square, int countSubstance, int countInstrument) {
        super(number, floor, square);
        this.countSubstance = countSubstance;
        this.countInstrument = countInstrument;
    }

    @Override
    public int calcCapacity(){
        return 20;
    }
    @Override
    public void printInfo(){
        System.out.println("\nХимическая лаборатория:\nНомер - " + getNumber() + "\nЭтаж - " +
                getFloor() + "\nПлощадь - " + getSquare() + "\nКоличество веществ - " + getCountSubstance() +
                "\nКоличество инструментов - "+ getCountInstrument());

    }

}
