
import java.util.AbstractList;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

    public Object[] top;
    private int size;
    private int initialCapacity = 5;
    private int extraCapacity = 5;

    /**
     * Creates a new ArrayList instance with the default initial capacity.
     */
    
    public class SNode<T> {
	public T value;
	public SNode<T> next;
	
	public SNode()
	{
		value = null;
		next = null;
	}
	
	public SNode(T value)
	{
		this.value = value;
		next = null;
	}
}
    
    public ArrayList() {
        top = new Object[initialCapacity];
        size = 0;
    }

    /**
     * Increases the capacity of this ArrayList instance so that it can hold at
     * least extraCapacity elements more. This method allocates a new array with
     * greater capacity than the current one (top.length + extraCapacity) and
     * copies all elements from top to the newly allocated array. The reference
     * top is then updated to point to the new array.
     *
     * @param extraCapacity increase the capacity of this ArrayList by this
     * amount
     */
    private void reserveExtraCapacity(int extraCapacity) {
        ArrayList<E> InfoList = new ArrayList<>();
        
    }

    /**
     * Increases the capacity of this list if its size equals the length of the
     * array where the data is stored. This method calls reserveExtraCapacity
     * when (size() >= top.length). reserveExtraCapacity is called using the
     * instance variable extraCapacity.
     */
    private void ensureCapacity() {
        if(size()>=top.length){
            InfoList.reserveExtraCapacity();
        }
    }

    /**
     * Shifts elements in the array (top) to the right, starting at the given
     * position.
     *
     * @param index the position in which the shift will begin
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index
     * > size())
     */
    
    private void shiftContentsRight(int index) {
        if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
    }

    @Override
    public void addFirst(E e) {
        ArrayList<E> newList = new ArrayList<E>(e);
        newList.next = top.next;
        top.next = newList;
        size++;
    }

    @Override
    public void addLast(E e) {
        ArrayList<E> newNode = new ArrayList<E>(e);

        ArrayList<E> current = top;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        ArrayList<E> newNode = new ArrayList<E>(element);
        ArrayList<E> previous = top;
        int count = 0;
        while (count < index) {
            previous = previous.next;
            count++;
        }
        ArrayList current = previous.next;
        newNode.next = current;
        previous.next = newNode;
        size++;

    }

    @Override
    public E getFirst() {
        if (top.next == null) {
            throw new NoSuchElementException();
        }

        return top.next.value;
    }

    @Override
    public E getLast() {
        if (top.next == null) {
            throw new NoSuchElementException();
        }

        ArrayList<E> current = top.next;
        while (current.next != null) {
            current = current.next;
        }

        return current.value;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        ArrayList<E> current = top;
        if (index < size) {
            for (int i = -1; i < index; i++) {
                current = current.next;
            }
        }
        return current.value;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        Object[] array = new Object[size];
                int i=0;
                for(ArrayList<E> x=top.next;x!=null; x=x.next)
                    array[i++]=x.value;
                
            return array;
    }
}
