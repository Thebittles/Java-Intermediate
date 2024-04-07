package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//We can implement Comparable here - diff from comparator
// With comparable you use compareTo
class Student implements Comparable<Student> {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

    @Override
    public int compareTo(Student that) {
        if (this.age > that.age) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class Test {

    public static void main(String[] args) {

        Comparator<Student> com = new Comparator<Student>() {

            public int compare(Student i, Student j) {
                if (i.age % 10 > j.age % 10) {
                    return 1;
                } else {
                    return -1;
                }
            };
        };

        // Manually specifying our sort - Integer implements if you look inside - but we
        // have to specify
        // Comparator<Student> com = new Comparator<Student>() {

        // public int compare(Student i, Student j) {
        // if (i.age > j.age) {
        // return 1;
        // } else {
        // return -1;
        // }
        // };
        // };

        List<Student> students = new ArrayList<>();

        students.add(new Student(21, "Irene"));
        students.add(new Student(12, "Jon"));
        students.add(new Student(18, "Gay"));
        students.add(new Student(1, "Gwen"));
        students.add(new Student(2, "Brodie"));

        Collections.sort(students, com); //Works with comparator
        Collections.sort(students); // Works only if you implement compareTo from Comparable
        for (Student s : students) {
            System.out.println(s);
        }
        // System.out.println(students);

        // List<Student> nums = new ArrayList<>();

        // nums.add(4);
        // nums.add(3);
        // nums.add(7);
        // nums.add(5);
        // nums.add(9);
        // nums.add(6);
        // System.out.println(nums);

        // // Collections.sort(nums); //
        // Collections.sort(nums, com); // If you want to sort on your own logic
        // comparator
        // System.out.println(nums);
    }
}
