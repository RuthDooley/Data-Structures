import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class LinkedDequeTest {
    @Test
    void testSize() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 5; ++i)
            ld.addFirst(i);
        assertEquals(5, ld.size());
    }

    @Test
    void testIsEmpty() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 10; ++i)
            ld.addFirst(i);
        for(int i = 0; i < 10; ++i)
            ld.removeFirst();
        assertEquals(true, ld.isEmpty());
    }

    @Test
    void testEnqueueFirst() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 10; ++i)
            ld.addLast(i);
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", ld.toString());
    }

    @Test
    void testFirst() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 10; ++i)
            ld.addLast(i);
        assertEquals(0, ld.first());
    }

    @Test
    void testDequeueFirst() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 10; ++i)
            ld.addLast(i);
        assertEquals(0, ld.removeFirst());
        assertEquals(9, ld.size());
    }

    @Test
    void testDequeueLast() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 10; ++i)
            ld.addLast(i);
        assertEquals(9, ld.removeLast());
        assertEquals(9, ld.size());
    }

    @Test
    void testEnqueueLast() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 10; ++i)
            ld.addFirst(i);
        assertEquals(9, ld.removeFirst());
        assertEquals(9, ld.size());
    }
}