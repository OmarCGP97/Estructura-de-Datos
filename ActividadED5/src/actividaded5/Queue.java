package actividaded5;

import java.util.NoSuchElementException;

public class Queue<E> implements IQueue<E> {

    private LinkedList<E> queue;

    public Queue() {
        queue = new LinkedList<E>();
    }

    @Override
    public void offer(E e) {
        queue.addFirst(e);
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeLast();
    }

    @Override
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.getLast();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

}
