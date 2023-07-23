/*
 * File: UserInterface.java
 * Author: Java, Java, Java
 * Description: This abstract interface defines the methods that
 *  are used to communicate game details. It serves as the superclass
 *  to the new version of KeyboardReader
 */
public interface UserInterface {
    public String getUserInput();
    public void report(String s);
    public void prompt(String s);
}
