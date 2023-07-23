public class TestABC {
    public static void test() {
        A a = new A();
        a.method();
        a = new B();
        a.method();
        B b = new B();
        b.method();
    }
    public static void main(String args[]) {
        test();
    }
    
    static class A { public void method() { System.out.println("A"); }}
    static class B extends A { public void method() { super.method(); System.out.println("B"); }}

}
