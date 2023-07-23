/*
 * File: Queue.java
 * Author: Java, Java, Java
 * Description: This class represents a queue abstract
 *  data type (ADT). A queue is a list that implements
 *  First-In-First-Out (FIFO) behavior, similar to a
 *  checkout line in a supermarket. To constrain the
 *  list's behavior in this way, the only public method's
 *  provided are enqueue(), which inserts an element at
 *  the rear of the list, and dequeue(), which removes
 *  the first element of the list. Thus a Queue is a
 *  specialization of a generic List, and can be defined
 *  as an extension of the List class.
 */

public class Queue extends List {

    /**
     *  Queue() constructor creates an empty list by 
     *   invoking the superclass constructor.
     */
    public Queue() {
        super();
    }

    /**
     *  enqueue() inserts its parameter at the rear of
     *   of the list by invoking the insertAtRear() method
     *   which is inherited from its superclass
     *  @param obj -- the Object being inserted
     */
    public void enqueue(Object obj) {
        insertAtRear(obj);
    }
   
    /**
     *  dequeue() removes the first element of the list
     *   by invoking the superclass's removeFirst() method
     */
    public Object dequeue() {
        return removeFirst();
    }

    /**
     *  main() creates a Queue and tests its behavior by
     *   inserting and then removing a string of characters.
     *   Note how the Character wrapper class is used to create
     *   Character objects.
     */
    public static void main(String argv[]) {
        Queue queue = new Queue();
        String string = "Hello this is a test string";
        System.out.println("String: " + string);
        for (int k = 0; k < string.length(); k++)
            queue.enqueue( new Character(string.charAt(k)));
        System.out.println("The current queue:");
        queue.print();

        Object o = null;
        System.out.println("Dequeuing:");
        while (!queue.isEmpty()) {
            o  = queue.dequeue();
            System.out.print( o.toString() );
        }
    } // main()

}// Queue
