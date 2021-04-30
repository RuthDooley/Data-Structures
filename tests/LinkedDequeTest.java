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
    void testAddFirst() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 3; ++i)
            ld.addFirst(i);
        assertEquals("[2, 1, 0]", ld.toString());
    }

    @Test
    void testFirst() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 3; ++i)
            ld.addFirst(i);
        assertEquals(2, ld.first());
    }

    @Test
    void testRemoveFirst() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 3; ++i)
            ld.addFirst(i);
        assertEquals(2, ld.removeFirst());
    }

    @Test
    void testAddLast() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 3; ++i)
            ld.addLast(i);
        assertEquals("[0, 1, 2]", ld.toString());
    }

    @Test
    void testLast() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 5; ++i)
            ld.addLast(i);
        assertEquals(4, ld.last());
    }

    @Test
    void testRemoveLast() {
        LinkedDeque<Integer> ld = new LinkedDeque<>();
        for(int i = 0; i < 5; ++i)
            ld.addLast(i);
        assertEquals(4, ld.removeLast());
    }l
}