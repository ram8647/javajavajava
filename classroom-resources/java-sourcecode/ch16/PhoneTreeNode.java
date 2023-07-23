/*
* Filename: PhoneTreeNode.java
* Author: Java, Java, Java Edition 3
* Date: September 15, 2005
* Description: This file contains a partial implementation
* of a PhoneTreeNode class. This class with a PhoneTree class
* can be expanded into an implementation of a  binary tree
* data structure with name and phone number data.
* This material occurs at the very end of Chapter 16.
*/

/*
* The PhoneTreeNode class
* Description: This partially implemented class along with
* a PhoneTree class could be expanded into an implementation
* of a binary tree data structure.  Only the contains()
* method is implemented.
*/
public class PhoneTreeNode {    private String name; // data    private String phone;  // data    private PhoneTreeNode left;  // points to the left subtree    private PhoneTreeNode right;  // points to the right subtree
    public PhoneTreeNode(String nam, String pho){ }
    public void setData(String nam, String pho){ }
    public String getName(){ }

    /**
    * contains() returns true if and only if there is a
    * node in the subtree rooted at this node which has
    * a name variable equal to nam.
    * @param nam is a string to be searched for.
    * @return true if nam is contained in the subtree rooted at 
    * this node.
    */    public boolean contains(String nam, String pho){        if (name.equals(nam))            return true;        else if(name.compareTo(nam) < 0) { // name < nam            if (right == null) return false;            else return right.contains(nam, pho);        } else { // name > nam            if (left == null) return false;            else return left.contains(nam, pho);        } // else
    } // contains()
    public void insert(String nam, String pho){ }
    // other methods
} // PhoneTreeNode class