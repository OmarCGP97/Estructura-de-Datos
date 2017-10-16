package actividaded6;
public interface IQueue<E> {
    /**
     * Inserts the specified element into this queue.
     *
     * @param e the element to add
     */
    public void offer(E e);

    /**
     * Retrieves and removes the head of this queue.
     * This method throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public E remove();

    /**
     * Retrieves, but does not remove, the head of this queue.
     * This method throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public E element();
	
    /**
     * Tests if this queue is empty.
     * @return true if and only if this queue contains no items; false otherwise.
     */
	public boolean isEmpty();
	
	/**
	 * Removes all of the elements from this queue. The queue will be empty after this call returns.
	 */
	public void clear();
	
	/**
	 * Returns the number of elements in this queue.
	 * @return the number of elements in this queue
	 */
	public int size();
	
	/**
	 * Returns an array containing all of the elements in this queue in proper sequence (from first to last element).
	 * The returned array will be safe in that no references to it are maintained by this list.
	 * (In other words, this method must allocate a new array).
	 * The caller is this free to modify the returned array.
	 * This method acts as a bridge between array-based and collection-based APIs.
	 * @return an array containing all of the elements in this queue in proper sequence
	 */
	public Object[] toArray();
}
