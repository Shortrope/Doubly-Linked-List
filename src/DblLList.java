/**
 * Created by Mario on 11/2/2014.
 */
public class DblLList<T> {

    private Node<T> first;
    private int size;

    private class Node<T> {
        public T item;
        public Node next;
        public Node prev;
    }

    private boolean indexIsValid(int index) {
        return (index >= 0 && index < size);
    }


    /*--- API ---*/
    public int size() { return size; }
    public void clear() {
        if (first != null) {
            Node n = null;
            while (first.next != null) {
                n = first;
                first = first.next;
                n.next = null;
                n.prev = null;
            }
            first.prev = null;
            first = null;
            size = 0;
        }
    }

    public void add(T item) {
        if (first == null) {
            first = new Node<T>();
            first.item = item;
        }
        else {
            Node n = first;
            first.next = n;
            n.prev = first;
            first.item = item;
        }
        size++;
    }
    public void add(T item, int index) {}
    public void addFirst(T item) {
        add(item);
    }
    public void addLast(T item) {}

    public T get() {
        return first.item;
    }
    public T get(int index) {
        if (!indexIsValid(index)) {
            return null;
        }
        Node n = first;
    }
    public T getFirst() {
        return get();
    }
    public T getLast() {
        return null;
    }

    public void set(T item, int index) {}

    public T remove() {
        return null;
    }
    public T remove(int index) {
        return null;
    }
    public T removeFirst() {
        return null;
    }
    public T removeLast() {
        return null;
    }



}
