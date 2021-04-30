public class ArrayQueue<E> implements Queue<E> {
    //default capacity
    public static final int CAPACITY = 1000;

    private E[] data;
    private int front = 0;
    private int rear = 0;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int CAPACITY) {
        data = (E[]) new Object[CAPACITY];
    }
    
    public static void main(String[] args) {
    }

    @Override
    public int size() {
        return ((rear - front) % CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        if (front == rear) return true;
        else return false;
    }

    @Override
    public void enqueue(E e) {
        if (size() >= CAPACITY) throw new RuntimeException("Queue full!");
        else {
            rear = ((front + size()) % CAPACITY);
            data[rear] = e;
            rear++;
        }
    }

    @Override
    public E first() {
        return data[front];
    }

    @Override
    public E dequeue() {
        if (this.isEmpty()) {
            System.out.println("ERROR: NOTHING TO DEQUEUE");
            return null;
        } else {
            E e = data[front];
            front = ((front + 1) % CAPACITY);
            return e;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = (front % CAPACITY); i < rear; i++) {
            sb.append(data[i] + ", ");
        }

        sb.replace(sb.length() - 2, sb.length(), "");
        sb.append("]");
        return sb.toString();
    }
}