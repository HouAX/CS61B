/*
 * Double-ended queue are sequence containers with dynamic sizes that can be expanded
 * or contracted on both ends.
 */
public class LinkedListDeque<T> {
    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p,T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /*
     * If deque is null, the prev and next of sentinel is the sentinel itself. Otherwise,
     * sentinel.next is the first item and sentinel.prev is the last item.
     * Update the size if necessary.
     */
    private Node sentinel;
    private int size;

    /* Create an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /* Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /* Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /* Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from the first to last, separated by a space. */
    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.item);
            System.out.print(' ');
            ptr = ptr.next;
        }
    }

    /*
     * Removes and returns the item at the front of the deque. If no such item
     * exists, returns null.
     */
    public T removeFirst() {
        //size -= 1;
        if (sentinel == sentinel.next) {
            return null;
        } else {
            T x = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return x;
        }
    }

    /*
     * Removes and returns the item at the back of the deque. If no such item exists,
     * returns null.
     */
    public T removeLast() {
        // size -= 1; An easily overlooked mistake.
        // The size should not decrease by one when an element from an empty list.
        if (sentinel.prev == sentinel) {
            return null;
        } else {
            T x = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return x;
        }
    }

    /*
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque.
     */
    public T get(int index) {
        Node ptr = sentinel.next;
        while (index > 0 && ptr != sentinel) {
            ptr = ptr.next;
            index -= 1;
        }
        return (ptr == sentinel) ? null : ptr.item;
    }

    /*
     * Same as get, but uses recursion.
     */
    private T getRecursive(int index, Node p) {
        if (p == sentinel) {
            return null;
        }
        if (index == 0) {
            return p.item;
        }
        return getRecursive(index - 1, p.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque();
        L.addFirst(3);
        L.addFirst(0);
        L.addLast(6);
        L.addLast(9);
        L.printDeque();
        System.out.println();
        System.out.println(L.isEmpty());
        System.out.println(L.size());
        LinkedListDeque<String> S = new LinkedListDeque();
        System.out.println(S.isEmpty());
        System.out.println(L.get(2));
        System.out.println(L.getRecursive(2));
        L.removeFirst();
        System.out.println(L.get(2));
        L.removeLast();
        System.out.println(L.get(2));
    }
}