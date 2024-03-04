# Chapter 17 - Lambdas

- Use lambdas and streams to simplify tasks that process sequences of elements

- Perform on IntStreams
- intermediate ops => filter, map, mapToObj, and sorted,
- terminal ops => forEach, count, min, max, sum, average, reduce

- Streams and Reduction
- How streams can be used to simplify programming tasks that you learned in chap 5.
- import java.util.
- Can think of it like chained methods - hits line, does something, passed on down

```java
//IntStream 
System.out.printf(
IntStream.rangeClosed(1, 10)
    .map((int x) -> { return x * 2})
    .sum()
)

```


- Lazy evaluation - each intermediate op results in a new stream obj but does not perform any ops on the streams elements until a terminal op is called to produce a result. Finds first object instead of going through everything.


- Terminal ops are eager they perform the requested operation 



- Common intermediate stream ops
    - filter
    - distinct
    - limit
    - map
    - sorted


```java
//filter
IntStream.rangeClosed(1, 10)
    .filter(x -> x % 2 == 0)
    .map(x -> x * 3)
    .sum()

```

```java
// Display 10 random ints on separate lines

SecureRandom randomNumbers = new SecureRandom();

randomNumbers.ints(10, 1, 7)
    .forEach(System.out::println);

```


```java

import java.util.stream.Collectors; //Stream has so many things

String numbers = 
randomNumbers.ints(10, 1, 7) //Gen 10 nums 1-7 7 non inclusive
    .mapToObj(String::valueOf)
    .collect(Collectors.joining(" "));


System.out.printf("%nRandom Numbers on one line: %s%n", numbers);
````