Java provides two interfaces to sort objects using data members of the class:

## Comparable Interface:

**Explanation:**

The Comparable interface in Java is used to impose a natural ordering on objects of a class.

It enables objects to be compared based on their inherent properties.

**Implementation:**

Let's say you have a class Number with a property value.

To sort instances of this class using Comparable, the class should implement the Comparable interface and override the compareTo() method to define the natural ordering based on the value property.

```java
import java.util.*;

class Number implements Comparable<Number> {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Number other) {
        return Integer.compare(this.value, other.value);
    }


    ////////////////////////////////////////


    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(5));
        numbers.add(new Number(2));
        numbers.add(new Number(8));
        Collections.sort(numbers);
        for (Number num : numbers) {
            System.out.println(num.getValue());
        }
    }
}
```

## Comparator Interface:

**Explanation:**

The Comparator interface in Java is used to define custom comparison logic for objects of a class. It allows sorting based on different criteria.

**Implementation:**

Similar to the Comparable approach, you define a class NumberComparator that implements the Comparator interface and override the compare() method to define the comparison logic.


```java 

import java.util.*;

class Number {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

class NumberComparator implements Comparator<Number> {
    @Override
    public int compare(Number num1, Number num2) {
        return Integer.compare(num1.getValue(), num2.getValue());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(5));
        numbers.add(new Number(2));
        numbers.add(new Number(8));
        
        NumberComparator comparator = new NumberComparator();
        Collections.sort(numbers, comparator);
        
        for (Number num : numbers) {
            System.out.println(num.getValue());
        }
    }
}

```