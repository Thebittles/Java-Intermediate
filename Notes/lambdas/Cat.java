public class Cat implements Printable {
    public String name;
    public int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println("Meow");
    }
}