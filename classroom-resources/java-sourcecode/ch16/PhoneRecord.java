/* Filename: PhoneRecord.java
 * Author: Java, Java, Java Edition 3
 * Date: September 15, 2005
 * Describes a data type for testing data types which
 * implements equals(), compareTo() and hashTable().
 */

import java.util.*;

/** The PhoneRecord class
* Description: Contains a single name and phone number.
* This version of the class implements comparable.
*/
public class PhoneRecord implements Comparable{
    private String name;
    private String phone;

    /**
    * PhoneRecord constructor
    * Creates an object containing the name and number.
    * @param aName is a person's name.
    * @param aPhone is a phone number for aName.
    */
    public PhoneRecord(String aName, String aPhone){
        name = aName;
        phone = aPhone;
    } // PhoneRecord() constructor

    /**
    * toString() overides the toString() of the Object class.
    * @return is a String with this object's name and number.
    */
    public String toString(){
        return name + " " + phone;
    } // toString()

    /**
    * getName returns the value of the name variable
    * @return name.
    */
    public String getName(){
        return name;
    } // getName()

    /**
    * getPhone returns the value of the phone variable
    * @return phone.
    */
    public String getPhone(){
        return phone;
    } // getPhone()

    /**
    * equals() overides the equals() of the Object class.
    * @param ob is a PhoneRecord object.
    * @return is true if the name variable of the two
    * PhoneRecord objects are equal as Strings.
    */
    public boolean equals(Object ob){
        return name.equals(((PhoneRecord)ob).getName());
    } // equals()

    /**
    * compareTo() implements the Comparable interface.
    * @param ob is a PhoneRecord object.
    * @return is -1, 0, or +1 if the name variable of
    * this PhoneRecord object is less, equal, or greater
    * than ob.name as Strings. 
    */
     public int compareTo(Object ob){
        return name.compareTo(((PhoneRecord)ob).getName());
    } // compareTo()

    /**
    * hashCode() overides hashCode() of the Object class.
    * @param ob is a PhoneRecord object.
    * @return is the hashCode() value of name as a String.
    */
    public int hashCode(){
        return name.hashCode();
    } // hashCode()

} // PhoneRecord
