package genericshomework;


public class MyStack<T>  {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public MyStack() {
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    Node<T> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    public void push(T value) {
        final Node<T> f = last;
        final Node<T> newNode = new Node<>(null, value, f);
        last = newNode;
        if (f == null)
            first = newNode;
        else
            f.next = newNode;
        size++;
    }
    public T remove(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);

        Node<T> x = node(index);
        final T element = x.item;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }
    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }
    public int size() {
        return size;
    }

    public T peek() {
        final Node<T> f = first;
        return (f == null) ? null : f.item;
    }

    public T pop() {
        final Node<T> f = first;
        final T element = f.item;
        final Node<T> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }
}
