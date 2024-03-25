
//Lambda only works with functional interface


//SAM - Single Abstract method interface
//OR a functional interface
@FunctionalInterface // Java 8 Feature
interface A {
    // public abstract is optional
    void show(int i);// public by default
}

// Can Skip creating a class by implementing below in main

// class B implements A {
// public void show() {
// System.out.println("In Show");
// }
// }

public class demo {
    public static void main(String[] args) {
        // Anon inner class - can instantiate
        // A obj = new A() {
        // public void show(int i) {
        // System.out.println("In Show" + i);
        // }
        // };

        // But compiler understands what you are trying to do
        A obj = (i) -> System.out.println("In Show" + i); // Don't have to mention type because its mentioned above
        obj.show(5);
    }
}
