package com.company;

public class Main {

    public static void main(String[] args) {
        EducateClass educateClass = new EducateClass(322, 3, 40, 24,true);
        educateClass.printInfo();

        Laboratory laboratory = new Laboratory(111,1,45,15);
        laboratory.printInfo();

        LectureHall lectureHall = new LectureHall(209,2,350,30,120,true);
        lectureHall.printInfo();

    }
}
