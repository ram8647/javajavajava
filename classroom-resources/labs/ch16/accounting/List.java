/*
 * File: List.java
 * Author: Java, Java, Java
 * Description: This class defines a generic list 
 *  data structure. A list is a structure consisting of nodes 
 *  that are linked together. In this definition  a single
 *  link is used between nodes. This class defines methods
 *  for accessing nodes in the list. Its only data is a
 *  reference (initially null) to the first element of the
 *  list.
 */

public class List {
    private Node head;   // Reference to the first Node
   
    /**
     * List() sets a newly created list to null
     */ 
    public List() {
        head = null;
    }
   
    /**
     * isEmpty() returns true iff this list has 0 elements
     */ 
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * print() prints the list by traversing from the head
     *  through the last element. It prints the string
     *  representation of each list element
     */ 
    public void print() {
        if (isEmpty()) 
            System.out.println("List is empty");
        Node current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.getNext();
        }       
    } // print()
   
    /**
     * insertAtFront() inserts its parameter at the front of
     *   the list.
     * @param newNode -- a reference to an Object, which 
     *   represents the data portion of the list's nodes
     */ 
    public void insertAtFront(Object newNode) {
       Node current =  new Node(newNode);
       current.setNext(head);
       head = current;
    }
   
    /**
     * insertAtRead() inserts its parameter at the rear of
     *   the list. 
     * @param newNode -- a reference to an Object, which 
     *   represents the data portion of the list's nodes
     * Algorithm: Starting at the head of the list, traverse
     *  the list until the end is found and insert the new node
     */ 
    public void insertAtRear(Object newNode) {
        if (isEmpty()) 
            head = new Node(newNode);
        else {
            Node current = head;                 // Start at head of list
            while (current.getNext() != null)    // Find the end of the list
                current = current.getNext();
            current.setNext(new Node(newNode));  // Insert the newNode
        }      
    } // insertAtRear()

    /**
     * removeFirst() returns a reference to the list's first element
     *  and removes that element from the list
     * Pre:  Head is nonnull. The list should not be empty.
     * Post: Head points to the new head of the list 
     */ 
    public Object removeFirst() {
        Node first = head;
        head = head.getNext();
        return first;
    } // removeFirst()
   
    /**
     * removeLast() returns a reference to the list's last element
     *  and removes that element from the list
     * Pre:  Head is nonnull. The list should not be empty.
     * Post: Head points to the new head of the list 
     * Algorithm: Note that special cases are handled separately.
     *  If the list as 1 or more elements, it must be traversed
     *  to find the last element.
     */ 
    public Object removeLast() {
        if (isEmpty())  // empty list
            return null;
         
        Node current = head;
        if (current.getNext() == null) {     // Singleton list
            head = null;
            return current;
        }
         
        Node previous = null;                // All other cases
        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(null);
        return current;
     } // removeLast()

} // List
