/*
 * File: CollegeStudent.java
 * Author: Java, Java, Java
 * Description: The CollegeStudent class extends Student.
 */
public class CollegeStudent extends Student {

    /**
     * CollegeStudent() default constructor
     */
    public CollegeStudent() { }  

    /**
     * CollegeStudent() constructor invokes the super constructor.
     * @param s, a String giving the student's name
     */
    public CollegeStudent(String s) {
        super(s);                      // Invoke super constructor
    }

    /**
     * toString() overrides Student toString() method.
     */
    public String toString() {
       return "My name is " + name +  
               " and I am a CollegeStudent.";
    }
}
