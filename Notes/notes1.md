# Compile

- Single File <span style="color: DarkOrange;">javac filename.java</span>
- Multiple files <span style="color: DarkOrange;">javac \*.java</span>

# Run

- Run a single file <span style="color: DarkOrange;">java filename</span>

## Snippets

- sout :System.out.println();

## Super/Subclasses

- You can assign a subclass to super but not vice versa (CANNOT - assign super to sub)
- final methods cannot be overridden - priv implicitly final & static

## Enum

## Chapter 16

- LinkedList, ArrayList, Vectors

- Comparable => override compareTo (collections sort calls)

- Comparator obj => compare => override pass laptop and comparatorObj

- Figure out which ones have natural sort

## Wrapper classes allow prim to be put into arrays aka objs

## Map Interface

- Hashtable
- Hashmap => LinkedHashMap
- Interface SortedMap => interface NavigableMap => TreeMap

## Program 3 - Figure 16.17

## Monday February 19th

### Object Serialization

- Used to read or write object to file
- serialized obj rep as a sequence of bytes includes => data, and type info
- After has been written can be read from file and deserialized

- Classes => ObjectinInputStream & ObjectOutputStream they implement the objectinput

- Sometimes will get an error will need to have a serialVersionUID - unique identifier

### Enumeration

- Allows you to create your own data type

```java

//enum type with constants that rep the game stat
private enum Status {CONTINUE, WON, LOST}

// ...later on in code
Status gameStatus; // can contain CONTINUE, WON or LOST

//update status
gameStatus = Status.WON

```

```java

//type with a constructor and explicit instance fields and accessors for these fields

public enum Book {
    //declare constants of enum type
    JHTP("Java How to Program", "2018"),
    CHTP("C How to Program", "2016");


    //instance fields
    private final String title //book title
    private final String copyrightYear // copyright year

    Book(){
        this.title = "";
        this.copyrightYear = "";
    }


    //Enum constructor
    Book(String title, String copyrightYear){
        this.title = title;
        this.copyrightYear = copyrightYear;
    }

}


```

## Lambdas & Streams

- Why Lambdas?

  - Enables Functional Programming
  - Readable and concise code
  - Easier-to-use APIs and Libraries
  - Enables Support for ???

- Pass the "behavior" as an arg and let the method perform all the possible combinations
- Not passing a behavoir passing an obj that contains different actions
- These actions don't belong to any class. They live in isolation.

```java
public void message(action){
    action(); // performs the action
}

```

- ^^^^ Lambda expression

- If the function lives in isolation there is no need for keyword "public"
- If the function is assigned to a variable then there is no need for a name
- We know what the return type is so there is not need for the work void

```java

aBlockOfCode =  () -> {
    System.out.print("Welcome to Java! 8");
}

```

- The data type for the variable, aBlockOfCode is a functional interface
