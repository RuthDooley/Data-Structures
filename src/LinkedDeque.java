public class LinkedDeque<E> implements Deque<E> {

    public static void main(String[] args) {
        // Tested in testing directory
    }

    DoublyLinkedList<E> dll;
    LinkedDeque() {
        dll = new DoublyLinkedList<E>();
    }

    @Override
    public int size() {
        return dll.size();
    }

    @Override
    public boolean isEmpty() {
        return dll.isEmpty();
    }

    @Override
    public E first() {
        return dll.get(0);
    }

    @Override
    public E last() {
        return dll.get(dll.size()-1);
    }

    @Override
    public void addFirst(E e) {
        dll.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        dll.addFirst(e);
    }

    @Override
    public E removeFirst() {
        return dll.removeFirst();
    }

    @Override
    public E removeLast() {
        return dll.removeLast();
    }

    public String toString() { return dll.toString(); }
}