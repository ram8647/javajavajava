/*
 * File: CyberPet.java
 * Author: Java, Java, Java
 * Description: The simple version of CyberPet
 */

public class CyberPet  {
  // DATA
  private boolean isEating = true;
  private boolean isSleeping = false;
  private String name = "no name";  // CyberPet's name
  // ADD NEW VARIABLE HERE
 
 // METHODS
  CyberPet ( String str ) // CONSTRUCTOR METHOD
    {
      name = str;
    }
   
  public void setName ( String str ) 
    { 
      name = str;
    } // setName()

  public String getName() 
    {
      return name;           // return CyberPet's name
    } // getName()

    //ADD NEW METHOD HERE

  public void eat()         // start eating
    {
      isEating = true;       // change the state
      isSleeping = false;
      System.out.println(name + " is eating");
      return;
    } // eat()

  public void sleep()       // start sleeping
    {
      isSleeping = true;     // change the state
      isEating = false;
      System.out.println(name + " is sleeping");
      return;
    } // sleep()

} // end of CyberPet class

