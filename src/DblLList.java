/**
 * Created by Mario on 11/2/2014.
 */
public class DblLList<T> {

    private Node<T> first;
    private int size;

    private class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> prev;
    }

    private boolean listIsEmpty() {
        return (size == 0);
    }
    private boolean indexIsValid(int index) {
        if (listIsEmpty()) return false;
        else return (index >= 0 && index < size);
    }
    private Node<T> getLastNode() {
        if (listIsEmpty()) {
            return null;
        } else {
            Node<T> n = first;
            while(n.next != null) {
                n = n.next;
            }
            return n;
        }

    }

    /*--- API ---*/
    public int size() { return size; }
    public void clear() {
        if (first != null) {
            Node<T> n = null;
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
            Node<T> oldFirst = first;
            first = new Node<T>();
            first.item = item;
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        size++;
    }
    public void add(T item, int index) {
        if (!indexIsValid(index)) return;
        else {
            Node<T> n = first;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            Node<T> newItem = new Node<T>();
            newItem.item = item;
            newItem.prev = n.prev;
            newItem.next = n;
            newItem.prev.next = newItem;
            n.prev = newItem;
            size++;
        }
    }
    public void addFirst(T item) {
        add(item);
    }
    public void addLast(T item) {
        Node<T> oldLast = getLastNode();
        if (oldLast == null) {
            first = new Node<T>();
            first.item = item;
        }
        else {
            Node<T> newLast = new Node<T>();
            newLast.item = item;
            newLast.prev = oldLast;
            oldLast.next = newLast;
        }
        size++;
    }


    public T get() {
        if (listIsEmpty()) return null;
        else return first.item;
    }
    public T get(int index) {
        if (!indexIsValid(index)) {
            return null;
        }
        Node<T> n = first;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.item;
    }
    public T getFirst() {
        return get();
    }
    public T getLast() {
        if (listIsEmpty()) return null;
        else return getLastNode().item;
    }

    public void set(T item, int index) {
        if (!indexIsValid(index)) return;
        else {
            Node<T> n = first;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            n.item = item;
        }
    }

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
