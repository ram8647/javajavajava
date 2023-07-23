/*
 * File: Cat.java
 * Author: Java, Java, Java
 * Description: Cat is a subclass of Animal.
 */
public class Cat extends Animal {

    /**
     * Cat() constructor sets its kind variable
     */
    public Cat() {
        kind = "cat";
    }

    /**
     * speak() implements the Animal speak() method. 
     *  When a cat speaks it says meow.
     */
    public String speak() {
        return "meow";
    }
}
