
public interface List<E> {
	
	/**
	 * Inserts the specified element at the beginning of this list.
	 * @param e the element to add
	 */
	public void addFirst(E e);
	
	/**
	 * Appends the specified element to the end of this list.
	 * @param e the element to add
	 */
	public void addLast(E e);
	
	/**
	 * Inserts the specified element at the specified position in this list
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	public void add(int index, E element);
	
	/**
	 * Removes and returns the first element from this list.
	 * @return the first element from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeFirst();
	
	/**
	 * Removes and returns the last element from this list.
	 * @return the last element from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeLast();
	
	/**
	 * Removes the element at the specified position in this list.
	 * Shifts any subsequent elements to the left (subtracts one from their indices).
	 * Returns the element that was removed from the list.
	 * @param index the index of the element to be removed
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	public E remove(int index);
	
	/**
	 * Removes the first occurrence of the specified element from this list, if it is present.
	 * If this list does not contain the element, it is unchanged.
	 * Returns true if this list contained the specified element (or equivalently, if this list changed as a result of the call).
	 * @param o element to be removed from this list, if present
	 * @return true if this list contained the specified element
	 */
	public boolean remove(Object o);
	
	/**
	 * Returns the first element in this list.
	 * @return the first element in this list.
	 * @throws NoSuchElementException if this list is empty
	 */
	public E getFirst();
	
	/**
	 * Returns the last element in this list.
	 * @return the last element in this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E getLast();
	
	/**
	 * Returns the element at the specified position in this list.
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	public E get(int index);
	
	/**
	 * Replaces the element at the specified position in this list with the specified element
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 */
	public E set(int index, E element);
	
	/**
	 * Returns true if this list contains the specified element.
	 * @param e element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean contains(E e);
	
	/**
	 * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element. 
	 * @param o element to search for
	 * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
	 */
	public int indexOf(Object o);
	
	/**
	 * Removes all of the elements from this list. The list will be empty after this call returns.
	 */
	public void clear();
	
	/**
	 * Returns the number of elements in this list.
	 * @return the number of elements in this list
	 */
	public int size();
	
	/**
	 * Returns true if this collection contains no elements.
	 * @return true if this collection contains no elements
	 */
	public boolean isEmpty();
	
	/**
	 * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
	 * The returned array will be safe in that no references to it are maintained by this list.
	 * (In other words, this method must allocate a new array).
	 * The caller is this free to modify the returned array.
	 * This method acts as a bridge between array-based and collection-based APIs.
	 * @return an array containing all of the elements in this list in proper sequence
	 */
	public Object[] toArray();
	
	/**
	 * Returns a string representation of this collection.
	 * The string representation consists of a list of the collection's elements in order, enclosed in square brackets ("[]").
	 * Adjacent elements are separated by the characters ", " (comma and space).
	 * Elements are converted to strings as by String.valueOf(Object).
	 */
	public String toString();
}