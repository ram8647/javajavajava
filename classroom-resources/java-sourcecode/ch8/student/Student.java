/*
 * File: Student.java
 * Author: Java, Java, Java
 * Description: A simple class to illustrate inheritance and polymorphism.
 */

public class Student {
    private String name;

    /**
     * Student() constructor sets the student's name.
     * @param s, a String giving the student name
     */
    public Student(String s) {
        name = s;
    }

    /**
     * getName() returns the student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * toString() overrides Object.toString()
     */
    public String toString() {
       return "My name is " + name;
    }

    /**
     * main() tests the toString() method.
     */
    public static void main(String args[]) {
        Student stu = new Student("Stu");
        System.out.println(stu.toString());
    }
}
