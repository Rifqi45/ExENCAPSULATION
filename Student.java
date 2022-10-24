package ENCAPSULATION;

import java.util.ArrayList;

public class Student extends Person {

    private int numCourses = 0;
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name, String address) {
        super(name, address);
    }

    public void addCourseGrade(String course, int grade) {
        courses.add(course);
        grades.add(grade);
        numCourses++;
    }

    public void printGrades() {
        for (int i = 0; i < numCourses; i++) {
            System.out.println(courses.get(i) + " : " + grades.get(i));
        }
    }

    public double getAverageGrade() {
        return grades.stream().reduce(0, (a, b) -> a + b) / numCourses;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }

}
