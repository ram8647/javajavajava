/*
 * File: Pig.java
 * Author: Java, Java, Java
 * Description: Pig is a subclass of Animal that implements
 *  the Speakable interface.
 */
public class Pig extends Animal implements Speakable {

    /**
     * Pig() constructor sets its kind variable
     */
    public Pig() {
        kind = "pig";;
    }

    /**
     * speak() implements the  speak() method of the Speakable interface.
     *  When a pig speaks it says oink.
     */
    public String speak() {
        return "oink";
    }
}
