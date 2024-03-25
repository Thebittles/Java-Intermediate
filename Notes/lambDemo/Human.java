
public class Human {
    private String name;
    private int age;

    public Human() {
        super();
    }

    public Human(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //Define in class
    public static int compareByNameThenAge(Human h1, Human h2) {
        if (h1.name.equals(h2.name)) {
            return h1.age - h2.age;
        } else {
            return h1.name.compareTo(h2.name);
        }
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

}
