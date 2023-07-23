/*
 * File: Animal.java
 * Author: Java, Java, Java
 * Description: Animal is an abstract class. It's speak()
 *  method is abstract and meant to be implemented in 
 *  Animal subclasses, such as Dog, Cat.
 */

public abstract class Animal {
    protected String kind; // Cow, pig, cat, etc.

    /**
     * Animal() default constuctor
     */
    public Animal()  {  }

    /**
     * toString() method overrides the Object toString() method.
     */
    public String toString() {
        return "I am a " + kind + " and I go " + speak();
    }

    /**
     * speak() returns an appropriate String representing
     *  the way a certain kind of animal speaks. It is 
     *  implemented in the Animal subclasses.
     */
    public abstract String speak();   // Abstract method

    /** 
     * main() creates instances of Animal subclasses and invokes
     *  their speak() methods, illustrating inheritance and 
     *  polymorphism.
     */
    public static void main(String args[]) {
        Animal animal = new Cow();
        System.out.println(animal.toString());
        animal = new Pig();
        System.out.println(animal.toString());
        animal = new Cat();
        System.out.println(animal.toString());
    }
}
