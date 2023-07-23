/*
 * File: Cow.java
 * Author: Java, Java, Java
 * Description: Cow is a subclass of Animal.
 */
public class Cow extends Animal implements Speakable {
    /**
     * Cow() constructor sets its kind variable
     */
    public Cow() {
        kind = "cow";
    }

    /**
     * speak() implements the speak() method from the Speakable interface. 
     *  When a cow speaks it says moo.
     */
    public String speak() {
        return "moo";
    }
}
