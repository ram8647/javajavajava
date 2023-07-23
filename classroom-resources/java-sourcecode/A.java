public class A {

    class B { 

	public void hello() {
	    System.out.println("Hello");
	}
    }

    B b;
    static A a;

    public static void main(String args[]) {
	a = new A();
        a.hi();
    }

    public void hi() {
        b = new B();
	b.hello();
    }
} // A
