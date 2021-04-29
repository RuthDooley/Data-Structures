import java.util.Iterator;

class DoublyLinkedList<E> implements List<E> {

    //---------------- nested Node class ----------------
    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    private static class Node<E> {
        private E element;

        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> prev, Node<E> next) {
            this.element = e;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> p){
            prev = p;
        }
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
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
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
    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if(i < (size()-1/2)) {
            Node<E> curr = header.getNext();

            for(int k=0;k<i;k++) {
                curr = curr.getNext();
            }
            return curr.element;
        } else {
            Node<E> curr = trailer.getPrev();
            for(int k=size()-1;k>i;k--) {
                curr = curr.getPrev();
            }
            return curr.element;
        }
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        Node<E> newNode = new Node<>(e, null, null);
        Node<E> currentNode = header;

        if (i > size) { return;
        } else {
            for (int count = 0; count < size; count++) {
                if (i == count) {
                    newNode.setNext(currentNode.getNext());
                    currentNode.setNext(newNode);
                    newNode.setPrev(currentNode);
                    currentNode.getNext().setPrev(newNode);
                    size++;
                    break;
                } else{
                    currentNode = currentNode.getNext();
                }
            }
        }
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        Node<E> nodeBefore;
        nodeBefore = header.getNext();
        for (int x = 0; x < i - 1; x++) {
            nodeBefore = nodeBefore.getNext();
        }
        return remove(nodeBefore.getNext());
    }

    private class ListIterator implements Iterator<E> {
        Node<E> curr;
        public ListIterator() {
            curr = header.getNext();
        }

        @Override
        public boolean hasNext() {
            return curr != trailer;
        }

        @Override
        public E next() {
            E res = (E) curr.getElement();
            curr = curr.getNext();
            return res;
        }
    }

    @Override
    public Iterator<E> iterator() { return new ListIterator(); }

    /**
     * Returns (but does not remove) the first element of the list.
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if (size == 0) return null;
        return header.getNext().getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        return trailer.getPrev().getElement();
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
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    /**
     * Removes and returns the last element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
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
        Node<E> previousNode = node.getPrev();
        Node<E> nextNode = node.getNext();

        previousNode.setNext(nextNode);
        nextNode.setPrev(previousNode);

        size--;
        return node.getElement();
    }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        StringBuilder retStr = new StringBuilder();
        Node<E> current = header.getNext();
        retStr.append("[");
        while(current.getNext().getNext() != null){

            retStr.append(current.getElement());
            retStr.append(", ");
            current = current.getNext();
        }
        retStr.append(current.getElement());
        retStr.append("]");
        return retStr.toString();
    }

    public static void main(String [] args) {
        //ArrayList<String> all;
        //LinkedList<String> ll;
        DoublyLinkedList<String> ll = new DoublyLinkedList<String>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            ll.addFirst(s);
            ll.addLast(s);
        }
        System.out.println(ll.toString());

        for (String s : ll) {
            System.out.print(s + ", ");
        }
    }
} //----------- end of DoublyLinkedList class -----------