import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArrayStackTest {
    @Test
    void testSize() {
        ArrayStack<Integer> s = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            s.push(i);
        assertEquals(5, s.size());
    }

    @Test
    void testIsEmpty() {
        ArrayStack<Integer> s = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            s.push(i);
        assertEquals(false, s.isEmpty());
        for(int i = 0; i < 5; ++i)
            s.pop();
        assertEquals(true, s.isEmpty());
    }

    @Test
    void testPush() {
        ArrayStack<Integer> s = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            s.push(i);
        assertEquals("[0, 1, 2, 3, 4]", s.toString());
    }

    @Test
    void testTop() {
        ArrayStack<Integer> s = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            s.push(i);
        assertEquals(4, s.top());
    }

    @Test
    void testPop() {
        ArrayStack<Integer> s = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            s.push(i);
        assertEquals(4, s.pop());
    }

    @Test
    void testToString() {
        ArrayStack<Integer> s = new ArrayStack<>();
        for(int i = 0; i < 5; ++i)
            s.push(i);
        assertEquals("[0, 1, 2, 3, 4]s", s.toString());
    }
}