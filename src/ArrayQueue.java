public class ArrayQueue<E> implements Queue<E> {
    public E[] data;
    public int front = 0;
    public int size = 0;
    public int length = 100;


    public ArrayQueue() {
        data=(E[]) new Object[length];  //setting new queue in constructor
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void enqueue(E e) {
        if(size == length) System.out.println("Full");
        data[size]=e;
        size++;
    }

    @Override
    public E first() {
        if(size < 1) return null;
        return data[0];
    }

    @Override
    public E dequeue() {
        if(isEmpty()) return null;
        E deq = data[front];
        data[front] = null;
        size--;
        front = front + 1;
        return deq;
    }
    }

}