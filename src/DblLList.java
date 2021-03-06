import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Mario on 11/2/2014.
 */
public class DblLList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;


    private class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> prev;

        public Node() {}
        public Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public DblLList() {};

    public DblLList(Collection<? extends T> c) {
        this();
        this.addAll(c);
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

    private Node<T> getNode(int index) {
        Node<T> n = first;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }


    /*--- API ---*/

    public Node<T> getPrevious(Node<T> item) {
        return item.prev;
    }

    public Node<T>  getNext(Node<T> item) {
        return item.next;
    }

    public int size() { return size; }

    public void clear() {
        if (first != null) {
            Node<T> n = null;
            while (first.next != null) {
                n = first;
                first = first.next;
                n.next = null;
                n.prev = null;
                n.item = null;
            }
            first.prev = null;
            first.item = null;
            last = null;
            size = 0;
        }
    }

    public void add(T item) {
        if (listIsEmpty()) {
            first = new Node<T>(null, item, null);
            last = first;
        }
        else {
            Node<T> oldLast = last;
            Node<T> newLast = new Node<T>(oldLast, item, null);
            oldLast.next = newLast;
            last = newLast;

        }
        size++;
    }

    // Inserts an item at the index given but also allows adding an
    // item to end of list by using an index of one greater than the
    // highest index  ..size()
    public void add(int index, T item) {
        if (indexIsValid(index) || index == size()){
            if (index == 0) {
                addFirst(item);
                return;
            } else if (index == size()){
                addLast(item);
                return;
            }
            Node<T> n = getNode(index);
            Node<T> newItem = new Node<T>(n.prev, item, n);
            newItem.prev.next = newItem;
            newItem.next.prev = newItem;
            size++;
        }
    }

    public void addFirst(T item) {
        if (listIsEmpty()) {
            first = new Node<T>(null, item, null);
            last = first;
        }
        else {
            Node<T> oldFirst = first;
            Node<T> newFirst = new Node(null, item, oldFirst);
            oldFirst.prev = newFirst;
            first = newFirst;
        }
        size++;
    }

    public void addLast(T item) {
        add(item);
    }

    public void addAll(Collection<? extends T> c) {
        Iterator iterator = c.iterator();
        while(iterator.hasNext()) {
            add((T) iterator.next());
        }
    }

    public void addAll(int index, Collection<? extends T> c) {
        if (indexIsValid(index) || (index == size())) {
            int i = index;
            Iterator iterator = c.iterator();
            while(iterator.hasNext()) {
                add(i, (T) iterator.next());
                i++;
            }
        }
    }

    public T get() {
        if (listIsEmpty()) return null;
        else return first.item;
    }

    public T get(int index) {
        if (!indexIsValid(index)) {
            return null;
        }
        return getNode(index).item;
    }

    public T getFirst() {
        return get();
    }

    public T getLast() {
        if (listIsEmpty()) return null;
        else return last.item;
    }

    public void set(T item, int index) {
        if (indexIsValid(index)) {
            Node<T> n = first;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            n.item = item;
        }
    }

    public T remove() {
        if (listIsEmpty()) return null;
        Node<T> oldFirst = first;
        Node<T> newFirst = first.next;
        if (newFirst != null) newFirst.prev = null;
        oldFirst.next = null;
        first = newFirst;
        size--;
        return oldFirst.item;
    }

    public T remove(int index) {
        if (indexIsValid(index)) {
            if (index == 0) return removeFirst();
            if (index == size - 1) return removeLast();
            Node<T> n = getNode(index);
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.prev = null;
            n.next = null;
            size--;
            return n.item;
        }
        else { return null; }
    }

    public T removeFirst() {
        return remove();
    }

    public T removeLast() {
        if (listIsEmpty()) return null;
        Node<T> n = last;
        if(n.prev != null) {
            last = n.prev;
            n.prev.next = null;
            n.prev = null;
        }
        size--;
        return n.item;
    }

    public DblLList<T> clone(DblLList<T> other) {
        if (other instanceof DblLList) {
            DblLList<T> clonedList = new DblLList<T>();
            for (int i = 0; i < other.size(); i++) {
                clonedList.add(other.get(i));
            }
            return clonedList;
        }
        return null;
    }

}
