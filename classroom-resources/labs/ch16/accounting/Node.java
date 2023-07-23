/*
 * File: Node.java
 * Author: Java, Java, Java
 * Description:  This class defines a node of a linked
 *  list data structure. Each node consists of a data
 *  portion, defined most generally as a Java Object,
 *  and link portion, which consists of a reference
 *  to a Node.  A linked list is created by establishing
 *  links from one node to another.
 */

public class Node {
    private Object data;        // Stores any kind of data
    private Node next;
  
    /** 
     * Node() constructor takes a reference to an object as
     *  its parameter. It stores the reference to the object
     *  and initializes its link to null.
     * @param obj -- a reference to an Object
     */
    public Node(Object obj) {  // Constructor
        data = obj;
        next = null;
    }
                               // Data access methods
    /** 
     * setData() sets the node's data to the referenced object
     * @param obj -- a reference to an Object
     */
    public void setData(Object obj) { 
        data = obj;
    }
  
    /** 
     * getData() returns a reference to this node's object
     */
    public Object getData() {
        return data;
    }
  
    /** 
     * toString() provides a String representation of this
     *  node's data by overriding Object.toString()
     */
    public String toString() {
        return data.toString();
    }
                               // Link access methods
    /** 
     * setNext() sets this node's link by assigning it a
     *  reference to a Node.
     * @param nextPtr -- a reference to a Node
     */
    public void setNext(Node nextPtr) { 
        next = nextPtr;
    }
  
    /** 
     * getNext() returns this node's link to the next object
     *   in the list.
     * @return -- a reference to a Node
     */
    public Node getNext() {
        return next;
    }
} // Node
