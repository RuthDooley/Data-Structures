public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> newLinkedList = new SinglyLinkedList<>();
    public static void main(String[] args) {
        LinkedStack<Integer> newStack = new LinkedStack<Integer>();
        //Test: Check push
        System.out.println("Push 3: ");
        newStack.push(3);
        System.out.println(newStack + "\n");

    }
    public LinkedStack() { }

    @Override
    public int size() {
        return newLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return newLinkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        newLinkedList.addFirst(e);
    }

    @Override
    public E top() {
        return newLinkedList.get(size()-1);
    }

    @Override
    public E pop() {
        E e = newLinkedList.removeLast();
        return e;
    }

    @Override
    public String toString() { return newLinkedList.toString(); }
}