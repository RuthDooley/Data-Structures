import java.util.Iterator;

class DoublyLinkedList<E> implements List<E> {

    //---------------- nested Node class ----------------
    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> prev, Node<E> next) {
            this.data = e;
            this.next = next;
            this.prev = prev;
        }

        public E getData() { return data; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
        public Node<E> getPrev() { return prev; }
        public void setPrev(Node<E> p) { prev = p; }
    } //----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    /** Sentinel node at the beginning of the list */
    private Node<E> header;                    // header sentinel

    /** Sentinel node at the end of the list */
    private Node<E> trailer;                   // trailer sentinel

    /** Number of elements in the list (not including sentinels) */
    private int size = 0;                      // number of elements in the list

    /** Constructs a new empty list. */
    public DoublyLinkedList() {
        header = new Node<> (null, null, null);
        trailer = new Node<> (null, header, null);
        header.setNext(trailer);
    }

    // public accessor methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() { return size; }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if(i < (size()-1/2)) {
            Node<E> curr = header.getNext();
            for(int x = 0; x < i; x++) {
                curr = curr.getNext();
            }
            return curr.data;
        } else {
            Node<E> curr = trailer.getPrev();
            for(int k=size()-1;k>i;k--){
                curr = curr.getPrev();
            }

            return curr.data;
        }
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        Node<E> prev = header;
        for (int x = 0; x < i; x++){
            prev = prev.next;
        }
        prev.data = e;
        return e;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        Node<E> curr = header.getNext();
        Node<E> prev = null;

        for(int x = 0;x < i; x++) {
            prev = curr;
            curr = curr.next;
        }

        //Function below
        addBetween(e, prev, curr);
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        Node<E> curr = header.getNext();
        Node<E> prev = header;

        for (int k = 0; k < i; k++) {
            prev = curr;
            curr = curr.getNext();
        }

        E e = curr.data;
        prev.next = curr.next;
        size--;
        return e;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Returns (but does not remove) the first element of the list.
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        return header.getNext().getData();
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        return trailer.getPrev().getData();
    }

    // public update methods
    /**
     * Adds an element to the front of the list.
     * @param e   the new element to add
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    /**
     * Adds an element to the end of the list.
     * @param e   the new element to add
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        if(size == 0)
            return null;
        else
            return remove(0);
    }

    /**
     * Removes and returns the last element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
        if(size == 0)
            return null;
        else
            return remove(size()-1);
    }

    // private update methods
    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param predecessor   node just before the location where the new element is inserted
     * @param successor     node just after the location where the new element is inserted
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Removes the given node from the list and returns its element.
     * @param node    the node to be removed (must not be a sentinel)
     */
    private E remove(Node<E> node) {
        Node<E> curr = header.getNext();
        Node<E> prev = header;

        //find the correct node to remove
        while (curr.next != node){
            prev = curr;
            curr = curr.getNext();
        }

        E e = curr.getData();
        prev.next = curr.next;
        size--;
        return e;
    }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<E> iter = header.getNext();
        while (iter.getNext() != null) {
            sb.append(iter.getData());
            sb.append(", ");
            iter = iter.getNext();
        }

        sb.replace(sb.length()-2, sb.length(), "");
        sb.append("]");

        return sb.toString();
    }

    public static void main(String [] args) {
        //Test: Sample Check
        DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        for (String s : alphabet) {
            dll.addFirst(s);
            dll.addLast(s);
        }
        System.out.println(dll.toString());

        DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();

        //Test: size and isEmpty Function
        System.out.println(ll.size()); //0
        if (ll.isEmpty()){ System.out.println("Linked list is empty");
        } else { System.out.println("Linked list is not empty"); }

        //Test: add function
        ll.add(0, 0);
        ll.add(1, 2);
        ll.add(1, 1);
        System.out.println(ll.toString()); //0, 1, 2
        ;
    }
} //----------- end of DoublyLinkedList class -----------