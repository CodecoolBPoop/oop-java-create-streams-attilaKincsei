package hu.akincsei.fibonacci;

import java.util.function.Supplier;

public class Main4 {
    public static void main(String[] args) {
        Supplier<Student> studentGenerator = Main4::employeeMaker;

        for (int i = 0; i < 10; i++) {
            System.out.println("#" + i + ": " + studentGenerator.get());
        }
    }

    public static Student employeeMaker() {
        return new Student("A",2);
    }

}

class Student {
    public String name;
    public double gpa;

    Student(String name, double g) {
        this.name = name;
        this.gpa = g;
    }

    @Override
    public String toString() {
        return name + ": " + gpa;
    }
}