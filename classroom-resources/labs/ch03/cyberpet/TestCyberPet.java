/*
 * File: TestCyberPet.java
 * Author: Java, Java, Java
 * Description: Tests a simple CyberPet class.
 */
public class TestCyberPet 
{
   public static void main (String argv[]) 
   { 
      CyberPet pet1;            // Declare CyberPet variables
      CyberPet pet2;
      pet1 = new CyberPet("Socrates");      // create pet1 named "Socrates"
      System.out.print("pet1's name is ");
      System.out.println( pet1.getName() ); // print pet1's name
     
      pet1.eat();
      pet1.sleep();                         // Tell pet1 to sleep
      pet2 = new CyberPet("Plato");         // create pet2 named "Plato"
      System.out.print("pet2's name is ");
      System.out.println( pet2.getName() ); // print pet1's name

      pet2.eat()  ;             // Tell pep2 to eat
      pet2.sleep();             // Tell pet2 to sleep
      return;                   // return to the system
   } // main
} // end TestCyberPet
