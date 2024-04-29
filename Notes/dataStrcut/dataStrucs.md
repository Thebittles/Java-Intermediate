

# Data Structures Chap 21.


## Example 21.2

```java
class Node<E>{
    private E data;
    private Node<E> nextNode;//reference to next node

    public Node(E data) //Const. body
    public void setData(E data)// { method body}
    public E getData() //{ method body }
    public void setNext(Node<E> next) //{ method body}
    public Node<E> getNext() // { method body}

}


```



## Example 21.3 

```java
//ListNode and List class declarations
package com.deitel.datastructures;


import java.util.NoSuchElementException;

class ListNode<E>{
    // package access members; List can access these directly 
    E data; //data for this node
    ListNode<E> nextNode; //Reference to the next node in the list

    //Const. create a ListNode that refers to object
    ListNode(E object) {
        this(object, null)
    }
}

```



