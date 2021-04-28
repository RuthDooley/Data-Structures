import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {
    // instance variables of the CircularlyLinkedList
    Node<E> tail = null; // we store tail (but not head)
    int size = 0; // number of nodes in the list
    //---------------- nested Node class ----------------
    /**
     * Singly linked node, which stores a reference to its element and
     * to the subsequent node in the list.
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E e, Node<E> next) {
            this.data = e;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

    } //----------- end of nested Node class -----------

    /** Constructs an initially empty list. */
    public CircularlyLinkedList() { }             // constructs an initially empty list

    // access methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() { return size; }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        if (tail == null) return true;
        else return false;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        Node<E> curr = tail.getNext();
        for (int x = 0; x < i; x++) {
            curr = curr.getNext();
        }
        return curr.data;
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        Node<E> curr = tail.getNext();
        for (int x = 0; x < i; x++) {
            curr = curr.getNext();
        }
        curr.data = e;
        return e;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        Node<E> curr = tail.getNext();
        Node<E> prev = null;

        for (int x = 0; x < i; x++) {
            prev = curr;
            curr = curr.getNext();
        }

        Node<E> newest = new Node<E>(e, curr);
        prev.setNext(newest);
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        Node<E> curr = tail.getNext();
        Node<E> prev = null;

        for (int x = 0; x < i; x++) {
            prev = curr;
            curr = curr.getNext();
        }

        E e = prev.data;
        prev.next = curr.next;
        size--;
        return e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        Node<E> curr;
        boolean first = true;

        public ListIterator() { curr = tail.getNext(); }

        @Override
        public boolean hasNext() {
            if (first) {
                first = false;
                return true;
            } else {
                return curr != tail.getNext();
            }

        }

        @Override
        public E next() {
            E res = (E) curr.getData();
            curr = curr.getNext();
            return res;
        }
    }

    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty)
     */
    public E first() {             // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return tail.getNext().getData();
    }

    /**
     * Returns (but does not remove) the last element of the list
     * @return element at the back of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getData();
    }

    // update methods
    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {         // rotate the first element to the back of the list
        if (tail != null)
            tail = tail.getNext( );
    }

    /**
     * Adds an element to the front of the list.
     * @param e  the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // link to itself circularly
        } else {
            Node<E> newNode = new Node<>(e, tail.getNext( ));
            tail.setNext(newNode);
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param e  the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
        addFirst(e); // insert new element at front of list
        tail = tail.getNext( );
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
        if (isEmpty( )) return null; // nothing to remove
        size = size - 1;
        Node<E> header = tail.getNext( );
        if (header == tail) tail = null; // must be the only node left
        else tail.setNext(header.getNext( )); // removes ”head” from the list
        return header.getData( );
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        StringBuilder newString = new StringBuilder();
        newString.append("[");

        Node<E> iter = tail.getNext();
        do {
            newString.append(iter.getData());
            newString.append(", ");
            iter = iter.getNext();
        } while (iter != tail.getNext());
        newString.replace(newString.length()-2, newString.length(), "");
        newString.append("]");

        return newString.toString();
    }


    public static void main(String [] args) {
        CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();

        //Test: size and isEmpty Function
        System.out.println(ll.size()); //0
        if (ll.isEmpty()){ System.out.println("Linked list is empty");
        } else { System.out.println("Linked list is not empty"); }

        //Test: addFirst and addLast and removeFirst
        ll.addFirst(1);
        ll.addLast(2);
        System.out.println(ll.toString()); // 1, 2
        ll.removeFirst();
        System.out.println(ll.toString()); // 2

        //Test: add fucntion
        ll.add(1,1);

        //Sample Test:
        CircularlyLinkedList<String> cll = new CircularlyLinkedList<>();
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            cll.addFirst(s);
            cll.addLast(s);
        }
        System.out.println(ll.toString());

        cll.rotate();
        cll.rotate();

        for (String s : cll) {
            System.out.print(s + ", ");
        }
    }
}