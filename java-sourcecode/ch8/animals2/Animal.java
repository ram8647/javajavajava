/*
 * File: Animal.java
 * Author: Java, Java, Java
 * Description: Animal is a superclass. It is meant to be
 *  overridden by subclasses such as Cat, Dog that implement
 *  the Speakable interface.
 */
public class Animal {
    protected String kind;  // Cow, pig, cat, etc.

    /**
     * Animal() default constuctor
     */
    public Animal()  {
    }

    /**
     * toString() method overrides the Object toString() method. 
     *  Note how it invokes the speak() method defined in the 
     *  Speakable interface. 
     */
    public String toString() {
        return "I am a " + kind + " and I go " + ((Speakable) this).speak();
    }

    /** 
     * main() creates instances of Animal subclasses and invokes
     *  their toString() methods, illustrating inheritance and 
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
