import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArrayStackTest {
    @Test
    void testSize() {
        ArrayStack<Integer> as = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            as.push(i);
        assertEquals(5, as.size());
    }

    @Test
    void testIsEmpty() {
        ArrayStack<Integer> as = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            as.push(i);
        assertFalse(as.isEmpty());
        for(int i = 0; i < 5; ++i)
            as.pop();
        assertTrue(as.isEmpty());
    }

    @Test
    void testPush() {
        ArrayStack<Integer> as = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            as.push(i);
        assertEquals("[0, 1, 2, 3, 4]", as.toString());
    }

    @Test
    void testTop() {
        ArrayStack<Integer> as = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            as.push(i);
        assertEquals(4, as.top());
    }

    @Test
    void testPop() {
        ArrayStack<Integer> as = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            as.push(i);
        assertEquals(4, as.pop());
    }

    @Test
    void testToString() {
        ArrayStack<Integer> as = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            as.push(i);
        assertEquals("[0, 1, 2, 3, 4]s", as.toString());
    }
}