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
        Node<E> currentNode = header;
        if (i < size && i >= 0) {
            for (int j = 0; j < size; j++) {
                if (j == i) {
                    return currentNode.getData();
                } else {
                    currentNode = currentNode.getNext();
                }
            }

        } else { currentNode = null; }
        return currentNode.getData();
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
        Node<E> current = header;
        if (i >= 0 && i <= size || size == 0) {
            if (size == 0) {
                header = new Node<E>(e, null, null);
                size++;
            } else if (i == 0) {
                this.addFirst(e);
            } else {
                for (int j = 0; j < size; j++) {
                    if (j == i - 1) {
                        current.setNext(new Node<E>(e, current.next, current));
                        size++;
                    } else {
                        current = current.next;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Cannot add()");
        }
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
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        Node<E> curr;
        public ListIterator() { curr = header.getNext(); }

        @Override
        public boolean hasNext() { return curr != trailer; }

        @Override
        public E next() {
            E res = (E) curr.getData();
            curr = curr.getNext();
            return res;
        }
    }

    /**
     * Returns (but does not remove) the first element of the list.
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if (isEmpty()) return null;
        return header.getData();
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        if (isEmpty()) return null;
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
        if(size == 0) return null;
        else return remove(0);
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
        Node<E> currentNode = header;
        StringBuilder newString = new StringBuilder();
        newString.append("[");
        for (int i = 0; i < size; i++) {
            if (i == 0) newString.append(currentNode.getData() + ", ");
            else newString.append(currentNode.getData()  + ", ");
            currentNode = currentNode.next;

        }
        newString.delete(newString.lastIndexOf(", "),newString.lastIndexOf(", ") + 2);
        newString.append("]");
        return newString.toString();
    }

    public static void main(String [] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();

        //Test: size and isEmpty Function
        System.out.println(ll.size()); //0
        if (ll.isEmpty()){ System.out.println("Linked list is empty");
        } else { System.out.println("Linked list is not empty"); }

        //Test: add function
        ll.add(0, 0);
        ll.add(1, 1);
        ll.add(2, 2);
        System.out.println(ll.toString()); //0, 1, 2

        //Test: get function
        System.out.println(ll.get(1)); //1
        System.out.println(ll.get(2)); //2

        //Test: set function
        ll.set(0, 2);
        ll.set(2, 0);
        System.out.println(ll.toString()); //2, 1, 0

        //Test: remove function
        ll.remove(2);
        System.out.println(ll.toString()); //2, 1

        //Test: addFirst and addLast functions removeFirst removeLast
        ll.addFirst(2);
        ll.addLast(1);
        System.out.println(ll.toString()); //2, 2, 1, 1
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll.toString()); //2, 1

        //Test: Sample Check
        DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        for (String s : alphabet) {
            dll.addFirst(s);
            dll.addLast(s);
        }
        System.out.println(dll.toString());

    }
} //----------- end of DoublyLinkedList class -----------