public class LinkedQueue<E> implements Queue<E> {
    SinglyLinkedList<E> sll = new SinglyLinkedList<E>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public int size() {
        return sll.size();
    }

    @Override
    public boolean isEmpty() {
        return sll.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        sll.addLast(e);
    }

    @Override
    public E first() {
        return sll.first();
    }

    @Override
    public E dequeue() {
        return sll.removeFirst();
    }

    @Override
    public String toString() { //For testing purposes
        return sll.toString();
    }

}