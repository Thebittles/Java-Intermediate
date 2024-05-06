1. Generic Class
A generic class is a class that takes one or more type parameters. The most common example of this in the Java Standard Library is the ArrayList.

```java
import java.util.ArrayList;

public class GenericClassExample {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        
        // Creating an ArrayList of Integers
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        
        System.out.println(stringList);
        System.out.println(intList);
    }
}
```
2. Generic Method
A generic method is a method that has its own type parameter. This is useful when you want to create a method that can operate on different types but still maintain type safety.

```java
public class GenericMethodExample {

    // Generic method that returns the first element of a list
    public static <T> T getFirstElement(T[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        return array[0];
    }

    public static void main(String[] args) {
        String[] strings = {"Apple", "Banana", "Cherry"};
        Integer[] integers = {1, 2, 3};
        
        // Using the generic method with different types
        System.out.println("First element (String): " + getFirstElement(strings));
        System.out.println("First element (Integer): " + getFirstElement(integers));
    }
}
```

3. Generic Interface
A generic interface can be used to create a contract for classes with type parameters. A common example is the Comparable interface.

```java
// Generic interface for a pair of items
interface Pair<K, V> {
    K getKey();
    V getValue();
}

// Class that implements a generic interface
class MyPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public MyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}

public class GenericInterfaceExample {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new MyPair<>("Age", 30);
        System.out.println("Key: " + pair.getKey());
        System.out.println("Value: " + pair.getValue());
    }
}
```
4. Bounded Generics
Bounded generics allow you to restrict the types that can be used with generics. This is useful when you want to ensure that a generic type has certain properties.

```java
// Bounded generic method to find the maximum of two numbers
public class BoundedGenericsExample {

    // The generic type T must implement Comparable<T>
    public static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        System.out.println("Max of 10 and 20: " + max(10, 20));
        System.out.println("Max of 'apple' and 'banana': " + max("apple", "banana"));
    }
}
```
