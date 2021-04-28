public class LinkedCircularQueue<E> implements Queue<E> {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    CircularlyLinkedList<E> queue;

    public LinkedCircularQueue() {
        queue = new CircularlyLinkedList<E>();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        queue.addLast(e);
    }

    @Override
    public E first() {
        return queue.get(0);
    }

    @Override
    public E dequeue() {
        return queue.removeFirst();
    }
}
