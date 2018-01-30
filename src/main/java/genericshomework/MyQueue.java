package genericshomework;

public class MyQueue<T>{
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public MyQueue() {
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

        public boolean add(T value) {
            final Node<T> l = last;
            final Node<T> newNode = new Node<>(l, value, null);
            last = newNode;
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            size++;
            return true;
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

        public T poll() {
            final Node<T> f = first;
            return (f == null) ? null : remove(0);
        }

        public T peek() {
            final Node<T> f = first;
            return (f == null) ? null : f.item;
        }

        public int size() {
            return size;
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

}
