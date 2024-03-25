
public class Lambdas {
    // https://www.youtube.com/watch?v=tj5sLSFjVj4
    // Streams - https://www.youtube.com/watch?v=tklkyVa7KZo

    public static void main(String[] args) {
        printThing(() -> System.out.println("Meow"));

    }

    static void printThing(Printable thing) {
        thing.print();
    }
}
