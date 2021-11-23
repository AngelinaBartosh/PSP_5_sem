package com.company;

public class Main {

    public static void main(String[] args) {
        EducateClass educateClass = new EducateClass(15,true);
        educateClass.printInfo();

        LectureHall lectureHall = new LectureHall(30,4,true);
        lectureHall.printInfo();

        ChemicalLaboratory chemicalLaboratory = new ChemicalLaboratory(415,4,30,67,50);
        chemicalLaboratory.printInfo();

        ComputerLaboratory computerLaboratory = new ComputerLaboratory(111,1,45,15,17,25);
        computerLaboratory.printInfo();

    }
}
