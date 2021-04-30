import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class qArrayQueueTest {

    @Test
    void testSize() {
        ArrayQueue<Integer> aq = new ArrayQueue<>();
        for(int i = 0; i < 10; ++i)
            aq.enqueue(i);
        assertEquals(10, aq.size());
    }

    @Test
    void testIsEmpty() {
        ArrayQueue<Integer> aq = new ArrayQueue<>();
        for(int i = 0; i < 2; ++i)
            aq.enqueue(i);
        assertEquals(false, aq.isEmpty());
        for(int i = 0; i < 2; ++i)
            aq.dequeue();
        assertEquals(true, aq.isEmpty());
    }

    @Test
    void testEnqueue() {
        ArrayQueue<Integer> aq = new ArrayQueue<>();
        for(int i = 0; i < 5; ++i)
            aq.enqueue(i);
        assertEquals("[0, 1, 2, 3, 4]", aq.toString());
    }

    @Test
    void testFirst() {
        ArrayQueue<Integer> aq = new ArrayQueue<>();
        aq.enqueue(7);
        assertEquals(7, aq.first());
    }

    @Test
    void testDequeue() {
        ArrayQueue<Integer> aq = new ArrayQueue<>();
        for(int i = 0; i < 10; ++i)
            aq.enqueue(i);
        assertEquals(0, aq.dequeue());
        assertEquals(9, aq.size());
    }
}
