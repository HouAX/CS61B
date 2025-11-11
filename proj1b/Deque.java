public interface Deque<T> {
    /* Adds an item of type T to the front of the deque. */
    public void addFirst(T item);

    /* Adds an item of type T to the back of the deque. */
    public void addLast(T item);

    /* Return true if deque is empty, false otherwise. */
    public boolean isEmpty();

    /* Returns the number of items in the deque. */
    public int size();

    /* Prints the items in the deque from the first to last, separated by a space. */
    public void printDeque();

    /*
     * Removes and returns the item at the front of the deque.
     * If no such item, returns null.
     */
    public T removeFirst();

    /*
     * Removes and returns the item at the back of the deque.
     * If no such item, returns null.
     */
    public T removeLast();

    /*
     * Gets the item at the given index.
     * If no such item, returns null.
     */
    public T get(int index);
}
