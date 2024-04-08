

import java.util.Comparator;

public class MyComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        // Implement your comparison logic here
        // For example, let's assume we are comparing integers
        if (o1 instanceof Integer && o2 instanceof Integer) {
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;
            return i1.compareTo(i2);
        }
        // Handle other types as needed
        return 0;
    }
}
