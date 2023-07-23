/*
 * File: Cat.java
 * Author: Java, Java, Java
 * Description: Cat is a subclass of Animal and it implements 
 *  the Speakable interface.
 */
public class Cat extends Animal implements Speakable {

    /**
     * Cat() constructor sets its kind variable
     */
    public Cat() {
        kind = "cat";
    }

    /**
     * speak() implements the speak() method of the Speakable interface.
     *  When a cat speaks it says meow.
     */
    public String speak() {
        return "meow";
    }
}
