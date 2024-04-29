- Predicate<T>: This functional interface represents a predicate (boolean-valued function) of one argument. It's commonly used for filtering elements based on certain conditions.

```java

import java.util.function.Predicate;

Predicate<Integer> isEven = num -> num % 2 == 0;
boolean result = isEven.test(5);

```

-- Function<T, R>: This functional interface represents a function that takes an argument of type T and returns a result of type R

```java

import java.util.function.Function;

Function<Integer, String> toStringFunction = num -> Integer.toString(num);
String result = toStringFunction.apply(123); // "123


```

-- Consumer<T>: This functional interface represents an operation that accepts a single input argument of type T and returns no result.

```java

import java.util.function.Consumer;

Consumer<String> printer = message -> System.out.println(message);
printer.accept("Hello, World!"); // prints "Hello, World!"

```

-- BinaryOperator<T>: This functional interface represents a binary operation upon two operands of the same type T, producing a result of the same type T

```java

import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = (a, b) -> a + b;
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        int resultAdd = add.apply(5, 3); // resultAdd = 8
        int resultMultiply = multiply.apply(5, 3); // resultMultiply = 15

        System.out.println("Addition Result: " + resultAdd);
        System.out.println("Multiplication Result: " + resultMultiply);
    }
}
```

-- Supplier<T>: This functional interface represents a supplier of results. It doesn't take any arguments but produces a result of type T.

```java
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello, World!";
        String result = supplier.get();
        System.out.println(result); // Output: Hello, World!
    }
}
```

-- UnaryOperator<T>: This functional interface represents an operation on a single operand of type T, producing a result of the same type T. It extends Function<T, T>.

```java
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<Integer> square = num -> num * num;
        int result = square.apply(5);
        System.out.println(result); // Output: 25
    }
}
```

## Streams

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
List<Integer> evenNumbers = numbers.stream()
                                   .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toList());
System.out.println(evenNumbers); // Output: [2, 4, 6, 8, 10]

```

```java

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
                 .reduce(0, Integer::sum);
System.out.println(sum); // Output: 15 (sum of all numbers)

```

```java
//Grouping

List<String> names = Arrays.asList("John", "Doe", "Alice", "Bob");
Map<Integer, List<String>> namesByLength = names.stream()
                                               .collect(Collectors.groupingBy(String::length));
System.out.println(namesByLength); // Output: {3=[Doe, Bob], 4=[John], 5=[Alice]}

```