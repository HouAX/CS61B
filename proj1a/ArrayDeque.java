/*
 * Uses arrays as the core data structure to implement deque
 */
public class ArrayDeque<T> {
    /*
     * Invariants:
     * nextFirst: Index when adding the item to the front of the deque.
     * nextLast: Index when adding the item to the back of the deque.
     * size: The number of items in the deque should be size.
     */
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    /*
     * Create an empty ArrayDeque.
     * The starting size of array should be 8.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    /* Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            a[i] = items[((i + nextFirst + 1) % items.length)];
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /* Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        // Update nextFirst
        nextFirst = (items.length + nextFirst - 1) % items.length;
        size += 1;
    }

    /* Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        // Update nextLast
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    /* Return true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from the first to last, separated by a space. */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[((i + nextFirst + 1) % items.length)]);
            System.out.print(' ');
        }
    }

    /* Checks if the underlying array length needs to be reduced. */
    public void checkArrayLength() {
        double usageRatio = (double) size / items.length;
        if (usageRatio < 0.25 && items.length >= 16) {
            resize(items.length / 2);
        }
    }

    /*
     * Removes and returns the item at the front of the deque.
     * If no such item, returns null.
     */
    public T removeFirst() {
        T x = items[(nextFirst + 1) % items.length];
        items[(nextFirst + 1) % items.length] = null;
        nextFirst = (nextFirst + 1) % items.length;
        size -= 1;
        checkArrayLength();
        return x;
    }

    /*
     * Removes and returns the item at the back of the deque.
     * If no such item, returns null.
     */
    public T removeLast() {
        T x = items[(items.length + nextLast - 1) % items.length];
        items[(items.length + nextLast - 1) % items.length] = null;
        nextLast = (items.length + nextLast - 1) % items.length;
        size -= 1;
        checkArrayLength();
        return x;
    }

    /*
     * Gets the item at the given index.
     * If no such item, returns null.
     */
    public T get(int index) {
        return items[(nextFirst + 1 + index) % items.length];
    }
}