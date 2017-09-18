
public interface IStack<E> {

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param e the element to be pushed onto this stack.
     * @return the e argument.
     */
    public E push(E e);

    /**
     * Removes the object at the top of this stack and returns that object as
     * the value of this function.
     *
     * @return The object at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public E pop();

    /**
     * Looks at the object at the top of this stack without removing it from the
     * stack.
     *
     * @return the object at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public E peek();

    /**
     * Tests if this stack is empty.
     *
     * @return true if and only if this stack contains no items; false
     * otherwise.
     */
    public boolean empty();

    /**
     * Returns an array containing all of the elements in this stack in proper
     * sequence (from the top of the stack to the bottom). The returned array
     * will be safe in that no references to it are maintained by this stack.
     * (In other words, this method must allocate a new array). The caller is
     * this free to modify the returned array. This method acts as a bridge
     * between array-based and collection-based APIs.
     *
     * @return an array containing all of the elements in this stack in proper
     * sequence
     */
    public Object[] toArray();
}
