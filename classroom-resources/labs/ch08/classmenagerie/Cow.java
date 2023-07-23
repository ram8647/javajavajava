/*
 * File: Cow.java
 * Author: Java, Java, Java
 * Description: Cow is a subclass of Animal.
 */
public class Cow extends Animal {

    /**
     * Cow() constructor sets its kind variable
     */
    public Cow() {
        kind = "cow";
    }

    /**
     * speak() implements the Animal speak() method. 
     *  When a cow speaks it says moo.
     */
    public String speak() {
        return "moo";
    }
}