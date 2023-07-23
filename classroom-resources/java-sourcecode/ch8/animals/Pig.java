/*
 * File: Pig.java
 * Author: Java, Java, Java
 * Description: Pig is a subclass of Animal.
 */
public class Pig extends Animal {

    /**
     * Pig() constructor sets its kind variable
     */
    public Pig() {
        kind = "pig";;
    }

    /**
     * speak() implements the Animal speak() method. 
     *  When a pig speaks it says oink.
     */
    public String speak() {
        return "oink";
    }
}
