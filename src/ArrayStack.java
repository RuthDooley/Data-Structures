public class ArrayStack<E> implements Stack<E> {
    private int i = -1; //Beginning int: index of array stack based on
    public static final int CAPACITY = 10; //Total capacity array stack allowed
    private E[] stack;
    public static void main(String[] args) {
        ArrayStack<Integer> newArrayStack = new ArrayStack<>();
        //Test: Check if empty
        System.out.println(newArrayStack.isEmpty());
        newArrayStack.push(10);
        System.out.println(newArrayStack.isEmpty());

        //Test: Check top
        System.out.println(newArrayStack.top().toString()); //10

        //Test: Check push with top and size
        newArrayStack.push(11);
        System.out.println(newArrayStack.top().toString()); //11
        newArrayStack.push(12);
        System.out.println(newArrayStack.top().toString()); //12
        System.out.println("Size is " + newArrayStack.size()); //3

        //Test: Check pop
        newArrayStack.pop();
        System.out.println(newArrayStack.top().toString()); //11
    }

    public ArrayStack() {
        this(CAPACITY);
    }

    @SuppressWarnings({"unchecked"})
    public ArrayStack(int CAPACITY)
    {
        stack = (E[]) new Object[CAPACITY];
    }

    @Override
    public int size() {
        return i + 1;
    }

    @Override
    public boolean isEmpty() {
        if(i == -1) return true;
        return false;
    }

    @Override
    public void push(E e) {
        if (size() == CAPACITY) throw new RuntimeException("Stack has reached capacity");
        else {
            i++;
            stack[i] = e;
        }
    }

    @Override
    public E top() {
        return stack[i];
    }

    @Override
    public E pop() {
        E temp = stack[i];
        stack[i] = null;
        i--;
        return temp;
    }

    public String toString() { //For testing
        StringBuilder newString = new StringBuilder();
        newString.append("[");
        for (int x = 0; x <= i; x++)
            newString.append(stack[x] + ", ");
        newString.replace(newString.length() - 2, newString.length(), "");
        newString.append("]");
        return newString.toString();
    }
}