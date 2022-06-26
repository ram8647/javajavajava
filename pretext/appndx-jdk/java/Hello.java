/**
 * A simple hello program
 * @author Java Java Java
 * @version 1.0
 */
public class Hello {

    /**
     * Prints a simple greeting.
     * 
     * @param None
     * @return void
     */
    public void sayHello() {
        System.out.println("Hello");
    }

    public static void main(String args[]) {
        Hello hello = new Hello();
        hello.sayHello();
    }
}