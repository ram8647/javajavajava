/*
 * File: Stack.java
 * Author: Java, Java, Java
 * Description: This class represents a stack abstract
 *  data type (ADT). A stack is a list that implements
 *  Last-In-First-Out (LIFO) behavior, similar to the way
 *  method-call-and-return works. To constrain the
 *  list's behavior in this way, the only public method's
 *  provided are push(), which inserts an element at
 *  the front or top the list, and pop(), which removes
 *  the first element of the list. Thus a stack is a
 *  specialization of a generic List, and can be defined
 *  as an extension of the List class.
 */

public class Stack extends List {

    /**
     *  Stack() constructor creates an empty list by 
     *   invoking the superclass constructor.
     */
    public Stack() {
        super();
    }

    /**
     *  push() inserts its parameter at the head of
     *   of the list by invoking the insertAtFront() method
     *   which is inherited from its superclass.
     *  @param obj -- the Object being inserted
     */
    public void push( Object obj ) {
        insertAtFront( obj );
    }
   
    /**
     *  pop() removes the first element of the list
     *   by invoking the superclass's removeFirst() method
     */
    public Object pop() {
        return removeFirst();
    }   

    /**
     *  main() creates a Stack and tests its behavior by
     *   inserting and then removing a string of characters.
     *   The result is that the string will be reversed, since
     *   the last character inserted will be the first removed.
     *   Note how the Character wrapper class is used to create
     *   Character objects.
     */
    public static void main( String argv[] ) {
        Stack stack = new Stack();
        String string = "Hello this is a test string";

        System.out.println("String: " + string);
        for (int k = 0; k < string.length(); k++)
            stack.push(new Character( string.charAt(k)));

        Object o = null;
        String reversed = "";
        while (!stack.isEmpty()) {
            o  = stack.pop();
            reversed = reversed + o.toString();
        }
        System.out.println("Reversed String: " + reversed);
    } // main()

} // Stack
