/*
* Filename: PhoneTree.java
* Author: Java, Java, Java Edition 3
* Date: September 15, 2005
* Description: This file contains a partial implementation
* of a PhoneTree class. This class with a PhoneTreeNode class
* can be expanded into an implementation of a  binary tree
* data structure with name and phone number data.
* This material occurs at the very end of Chapter 16.
*/

/*
* The PhoneTree class
* Description: This partially implemented class along with a
* PhoneTreeNode class could be expanded into an implementation
* of a binary tree data structure.  Only the contains()
* method is implemented.
*/
public class PhoneTree {
    private PhoneTreeNode root; // points to the binary tree

    public PhoneTree(){ }

    /**
    * contains() returns true if and only if the binary tree
    * which root points to has a node with its name variable 
    * equal to nam.
    * @param nam is a string to be searched for.
    * @return true if nam is contained in the tree which root 
    * points to.
    */    public boolean contains(String nam, String pho){        if (root == null) return false;        else return root.contains(nam, pho);    } // contains()

    public void insert(String nam, String pho){ }

    // other methods
} // PhoneTree class