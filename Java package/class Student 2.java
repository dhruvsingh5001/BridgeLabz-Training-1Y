package com.school.data;

public class Student {
    String name;
    int marks1;
    int marks2;
    int marks3;

    public Student(String name, int marks1, int marks2, int marks3) {
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public String getName() {
        return name;
    }

    public int getMarks1() {
        return marks1;
    }

    public int getMarks2() {
        return marks2;
    }

    public int getMarks3() {
        return marks3;
    }

    @Override
    public String toString() {
        return "Student Name: " + name +
               "\nMarks in Subject 1: " + marks1 +
               "\nMarks in Subject 2: " + marks2 +
               "\nMarks in Subject 3: " + marks3;
    }
}
