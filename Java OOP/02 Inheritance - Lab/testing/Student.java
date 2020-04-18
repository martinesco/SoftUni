package testing;

import java.util.ArrayList;
import java.util.List;

public class Student extends  Person{

    private List<Double> grades;

    public Student(String name, int age) {
        super(name, age);
        this.grades = new ArrayList<>();
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    @Override
    public void setAge(int age) {
        if (age < 6) {
            throw  new IllegalArgumentException();
        }
        super.setAge(age);
    }


    public void sleep(){
        System.out.println("Student in Deep Sleep");
    }
}
