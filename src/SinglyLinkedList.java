import java.util.Iterator;

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
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        //If empty, i > size of linked list
        if (isEmpty() || i > size()){ return null; }

        Node<E> curr = head;
        Node<E> prev = null;

        //Move i nodes to get the correct data
        for (int x = 0; x < i; x++){
            prev = curr;
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    //Set a node in index i in the linked list to value of e?
    public E set(int i, E e) throws IndexOutOfBoundsException {

        return null;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
//        Node<E> newNode = new Node<>(e, null);
//        Node<E> prev = head;

        if (i == 0) {
            addFirst(e);
            return;
        }

        Node<E> curr = head;
        Node<E> prev = null;

        for(int k = 0; k < i; k++) {
            prev = curr;
            curr = curr.next;
        }

        Node<E> newest = new Node<E>(e, curr.next);
        //insert in between the two nodes either side of i
        prev.next = newest;
        newest.next = curr;
        size++;



//        for (int x = 1; x < i; x++){ prev = prev.next; }
//        Node<E> current = prev.next;
//        newNode.next = current;
//        prev.next = newNode;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * Returns (but does not remove) the first element of the list
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        // TODO
        return null;
    }

    /**
     * Returns the last node of the list
     *
     * @return last node of the list (or null if empty)
     */
    public Node<E> getLast() {
        // TODO
        return null;
    }

    /**
     * Returns (but does not remove) the last element of the list.
     *
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        // TODO
        return null;
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
        return null;
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        // TODO
        return null;
    }

    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {
        // TODO
        return false;   // if we reach this, everything matched successfully
    }

    @SuppressWarnings({"unchecked"})
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        // TODO
        return null;
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

    private class SinglyLinkedListIterator<E> implements Iterator<E> {
        @Override
        public boolean hasNext() {
            // TODO
            return false;
        }

        @Override
        public E next() {
            // TODO
            return null;
        }
    }

    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();

        //Test: Check addFirst method and toString
        ll.addFirst(1);
        ll.addFirst(0);
        System.out.println(ll.toString()); // 0, 1

        //Test: Check addLast
        ll.addLast(2);
        ll.addLast(3);
        System.out.println(ll.toString()); // 0, 1, 2, 3

        //Test: Check add function
        ll.add(5, 3);
        ll.add(6, 4);
        System.out.println(ll.toString()); // 0, 1, 2, 3, 4, 5


//        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
//
//        for (String s : alphabet) {
//            sll.addFirst(s);
//            sll.addLast(s);
//        }
//        System.out.println(sll.toString());
//
//        for (String s : sll) {
//            System.out.print(s + ", ");
//        }
    }
}
