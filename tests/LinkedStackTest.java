import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LinkedStackTest {
    @Test
    void testSize() {
        LinkedStack<Integer> ls = new LinkedStack<>();
        for(int i = 0; i < 10; ++i)
            ls.push(i);
        assertEquals(10, ls.size());
    }

    @Test
    void testIsEmpty() {
        LinkedStack<Integer> ls = new LinkedStack<>();
        for(int i = 0; i < 10; ++i)
            ls.push(i);
        for(int i = 0; i < 10; ++i) {
            ls.pop();
        }
        assertEquals(true, ls.isEmpty());
    }

    @Test
    void testPush() {
        LinkedStack<Integer> ls = new LinkedStack<>();
        for(int i = 0; i < 10; ++i)
            ls.push(i);
        assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", ls.toString());
    }

    @Test
    void testTop() {
        LinkedStack<Integer> ls = new LinkedStack<>();
        for(int i = 0; i < 5; ++i)
            ls.push(i);
        assertEquals(0, ls.top());
    }

    @Test
    void testPop() {
        LinkedStack<Integer> ls = new LinkedStack<>();
        for(int i = 0; i < 5; ++i)
            ls.push(i);
        assertEquals(0, ls.pop());
    }

    @Test
    void testToString() {
        LinkedStack<Integer> ls = new LinkedStack<>();
        ls.push(1);
        ls.push(0);
        assertEquals("[0, 1]", ls.toString());
    }
}
