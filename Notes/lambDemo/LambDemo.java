import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambDemo {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Sarah", 19));
        humans.add(new Human("Dexter", 32));

        // OG Way
        Collections.sort(humans, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        });

        // Now with lambda...
        humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));

        // With method defined in human class...
        humans.sort(Human::compareByNameThenAge);

        // Let compiler create comparative for use by using ref to instance
        Collections.sort(humans, Comparator.comparing(Human::getName));

        Comparator<Human> myCompare = (h1, h2) -> h1.getName().compareTo(h2.getName());
        humans.sort(myCompare.reversed());

        System.out.println(humans);

    }// Closes main
}
