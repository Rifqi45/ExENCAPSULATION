package ENCAPSULATION;

import java.util.ArrayList;

public class Teacher extends Person {

    private int numCourses = 0;
    private ArrayList<String> courses = new ArrayList<>();

    public Teacher(String name, String address) {
        super(name, address);
    }

    public boolean addCourse(String course) {
        if (courses.contains(course)) {
            return false;
        }
        return courses.add(course);
    }

    public boolean removeCourse(String course) {
        if (!courses.contains(course)) {
            return false;
        }
        return courses.remove(course);
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }

}
