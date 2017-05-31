 public class A {
     public A() { System.out.println("A"); }

     public static void main(String args[]) {
         // Determine the output.
         A a = new A();
         B b = new B();
         C c = new C();
     }
 }

 class B extends A {
     public B() { System.out.println("B"); }
 }

 class C extends B {
     public C() { System.out.println("C"); }

 }

