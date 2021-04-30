import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircularQueueTest {

    @Test
    void testSize() {
        LinkedCircularQueue<Integer> cl = new LinkedCircularQueue<>();
        for(int i = 0; i < 10; ++i)
            cl.enqueue(i);
        assertEquals(10, cl.size());
    }

    @Test
    void testIsEmpty() {
        LinkedCircularQueue<Integer> cl = new LinkedCircularQueue<>();
        for(int i = 0; i < 10; ++i)
            cl.enqueue(i);
        for(int i = 0; i < 10; ++i)
            cl.dequeue();
        assertEquals(true, cl.isEmpty());
    }

    @Test
    void testEnqueue() {
        LinkedCircularQueue<Integer> cl = new LinkedCircularQueue<>();
        for(int i = 0; i < 5; ++i)
            cl.enqueue(i);
        assertEquals("[0, 1, 2, 3, 4]", cl.toString());
    }

    @Test
    void testFirst() {
        LinkedCircularQueue<Integer> cl = new LinkedCircularQueue<>();
        cl.enqueue(7);
        assertEquals(7, cl.first());
    }

    @Test
    void testDequeue() {
        LinkedCircularQueue<Integer> cl = new LinkedCircularQueue<>();
        for(int i = 0; i < 10; ++i)
            cl.enqueue(i);
        assertEquals(0, cl.dequeue());
        assertEquals(9, cl.size());
    }
}