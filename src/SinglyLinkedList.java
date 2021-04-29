import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A basic singly linked list implementation.
 */
public class SinglyLinkedList<E> implements Cloneable, Iterable<E>, List<E> {
    //---------------- nested Node class ----------------
    /**
     * Node of a singly linked list, which stores a reference to its
     * element and to the subsequent node in the list (or null if this
     * is the last node).
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;

        //Constructor for node
        public Node(E e, Node<E> next) {
            this.data = e;
            this.next = next;
        }

        //Appropriate getters and setters for node
        public E getData() { return data; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    } //----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private int size = 0; // number of nodes in the list

    public SinglyLinkedList() { } // constructs an initially empty list

    // access methods

    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        //If empty, i > size of linked list
        if (isEmpty() || i > size()){ return null; }
        Node<E> curr = head;

        //Move i nodes to get the correct data
        for (int x = 0; x < i; x++){
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    //Set a node in index i in the linked list to value of e?
    public E set(int i, E e) throws IndexOutOfBoundsException {
        Node<E> prev = head;
        for (int x = 0; x < i; x++){
            prev = prev.next;
        }
        prev.data = e;
        return null;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        Node<E> newest = new Node<>(e, null);
        Node<E> prev = head;
        for (int x = 1; x < i; x++ ){
            prev = prev.next;
        }
        Node<E> current = prev.next;
        newest.next = current;
        prev.next = newest;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i == 0) {
            E e = removeFirst();
            return e;
        }

        Node<E> curr = head;
        Node<E> prev = null;
        int x = 0;

        while (curr != null && x != i) {
            prev = curr;
            curr = curr.next;
            x++;
        }

        E e = prev.getData();
        prev.next = curr.next;
        size--;
        return e;
    }

    /**
     * Returns (but does not remove) the first element of the list
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if (head == null){
            return null;
        } else {
            return head.getData();
        }
    }

    /**
     * Returns the last node of the list
     *
     * @return last node of the list (or null if empty)
     */
    public Node<E> getLast() {
        Node lastNode = head;
        Node next = head.next;

        while (next != null) {
            lastNode = next;
            next = next.next;
        }

        return lastNode;
    }

    /**
     * Returns (but does not remove) the last element of the list.
     *
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        if (isEmpty()) return null;
        return get(size()-1);
    }

    // update methods

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {
        head = new Node<E>(e, head);
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {
       if (head == null){
           head = new Node<E> (e, null);
       } else {
           Node<E> newNode = head;
           while (newNode.next != null){
               newNode = newNode.next;
           }
           newNode.next = new Node<> (e, null);
       }
       size++;
    }

    public E removeLast() {
        if (head == null){
            throw new IndexOutOfBoundsException("List is empty");
        } else if (head.getNext() == null){
            size--;
            E e = head.getData();
            head = null;
            return e;
        }

        Node<E> curr = head;
        Node<E> prev = null;
        while (curr.next != null){
            prev = curr;
            curr = curr.getNext();
        }

        E e = curr.getData();
        prev.next = null;
        size--;
        return e;
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        if (size() == 1) {
            E e = head.getData();
            head = null;
            size--;
            return e;
        } else {
            E temp = head.getData();
            head = head.getNext();
            size--;
            return temp;
        }
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        SinglyLinkedList ll2 = (SinglyLinkedList) o;
        if (size != ll2.size) return false;
        Node first = head;
        Node second = ll2.head;
        while (first != null) {
            if (!first.getData().equals(second.getData( ))) return false;
            first = first.getNext();
            second = second.getNext();
        }
        return true;
    }

    public SinglyLinkedList<E> clone( ) throws CloneNotSupportedException {
        SinglyLinkedList<E> ll2 = (SinglyLinkedList<E>) super.clone( );
        if (size > 0) {
            ll2.head = new Node<>(head.getData(), null);
            Node<E> first = head.getNext();
            Node<E> tail = ll2.head;
            while (first != null) {
                Node<E> curr = new Node<>(first.getData(), null);
                tail.setNext(curr);
                tail = curr;
                first = first.getNext( );
                }
            }
        return ll2;
        }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        Node<E> newNode = head;
        String result = "[";
        while (newNode != null){
            result += newNode.getData();
            newNode = newNode.next;
            if(newNode != null)
                result += ", ";
        }
        return  result +="]";
    }
    public Iterator<E> iterator(){ return new SinglyLinkedListIterator(head);}
    public class SinglyLinkedListIterator implements Iterator<E> {
        private Node current;
        public SinglyLinkedListIterator(Node e){this.current=e;}
        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E tempNode = (E) current.getData();
            current = current.getNext();
            return tempNode;
        }
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();

        //Test: isEmpty Function
        if (ll.isEmpty()){ System.out.println("Linked list is empty");
        } else { System.out.println("Linked list is not empty"); }

        //Test: Check addFirst method and toString
        ll.addFirst(1);
        ll.addFirst(0);
        System.out.println(ll.toString()); // 0, 1

        //Test: Check addLast
        ll.addLast(2);
        ll.addLast(3);
        System.out.println(ll.toString()); // 0, 1, 2, 3

        //Test: Check add function
        ll.add(4, 4);
        ll.add(5, 5);
        System.out.println(ll.toString()); // 0, 1, 2, 3, 4, 5

        //Test: Check size and isEmpty Function for false
        System.out.println(ll.size()); //6
        if (ll.isEmpty()){ System.out.println("Linked list is empty");
        } else { System.out.println("Linked list is not empty"); }

        //Test: Check set function
        ll.set(0, 1);
        ll.set(1, 2);
        ll.set(2, 3);
        ll.set(3, 4);
        ll.set(4, 5);
        ll.set(5, 6);
        System.out.println(ll.toString()); // 1, 2, 3, 4, 5, 6

        //Test: Check remove function and removeFirst
        ll.remove(1);
        System.out.println(ll.toString()); // 1, 3, 4, 5, 6
        ll.removeFirst();
        System.out.println(ll.toString()); // 3, 4, 5, 6

        //Test: Check removeLast function
        ll.removeLast();
        ll.removeLast();
        System.out.println(ll.toString()); // 3, 4

        //Test: Check first and last methods and getLast
        System.out.println(ll.first()); //3
        System.out.println(ll.last()); //4
        System.out.println(ll.getLast().getData());
        System.out.println(ll.get(0));

        //Test: Clone the linked list
        SinglyLinkedList<Integer> newll = new SinglyLinkedList<Integer>();
        newll = ll.clone();
        System.out.println(ll.toString()); //3, 4
        System.out.println(newll.toString()); //Should be the same

        //Test: Check if linked list is equal
        if (ll.equals(newll)) System.out.println("True");
        else System.out.println("False");
        SinglyLinkedList<Integer> wrongll = new SinglyLinkedList<Integer>();
        if (ll.equals(wrongll)) System.out.println("True");
        else System.out.println("False");

        //Test: Sample Test
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            sll.addFirst(s);
            sll.addLast(s);
        }
        System.out.println(sll.toString());

        for (String s : sll) {
            System.out.print(s + ", ");
        }
    }
}
