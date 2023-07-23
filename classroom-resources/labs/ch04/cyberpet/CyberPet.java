/*
 * File: CyberPet.java
 * Author: Java, Java, Java
 * Description: This class represents a CyberPet that can
 *  eat and sleep on command. This version incorporates
 *  a public getState() method to report the pet's state.
 */

public class CyberPet 
{
    private boolean isEating = true;    // CyberPet's state
    private boolean isSleeping = false;
    private String name = "no name";    // CyberPet's name

    public CyberPet (String str)        // Constructor method
    {
        name = str;
    } 

    public void setName (String str)    // Access method
    { 
        name = str;
    } // setName()

    public String getName() 
    {
        return name;           // Return CyberPet's name
    } // getName()

    public void eat()          // Start eating
    {
        isEating = true;       // Change the state
        isSleeping = false;
        return;
    } // eat()

    public void sleep()        // Start sleeping
    {
        isSleeping = true;     // Change the state
        isEating = false;
        return;
    } // sleep()

    public String getState () 
    { 
        if (isEating)
            return "Eating";     // Exit the method
        if (isSleeping) 
            return "Sleeping";   // Exit the method
        return "Error in State"; // Exit the method
    } // getState()

    public String toString() 
    {
        return name + " is " + getState();
    }
} // CyberPet
