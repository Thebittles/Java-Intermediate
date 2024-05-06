// Employee class implementing Comparable to sort by age

import java.util.Comparator;

class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private int age;

    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return String.format("%s %s, Age: %d", firstName, lastName, age);
    }
}

//New Class
// Comparator to sort by the length of the last name
class LastNameLengthComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getLastName().length(), e2.getLastName().length());
    }
}
