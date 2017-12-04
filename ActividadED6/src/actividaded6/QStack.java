package actividaded6;
import java.util.NoSuchElementException;
/**
 *
 * @author Omar Castañeda
 */
public abstract class QStack<E> implements IStack<E> {

	private Queue<E> queue1;
	private Queue<E> queue2;

	public QStack() {
		queue1 = new Queue<E>();
		queue2 = new Queue<E>();
	}

	@Override
	public E push(E e) {
		queue1.offer(e);
                return null;
	}

	@Override
	public E pop() {
		queue1.remove();
		return null;
	}

	@Override
	public E peek() {
		queue1.element();
		return null;
	}

	@Override
	public boolean empty() {
		return queue1.isEmpty();
	}

	public void clear() {
		queue1.clear();
	}
	
	public int size() {
		return queue1.size();
	}
	
	@Override
	public String toString(){
		return new StringBuilder(queue1.toString()).reverse().toString();
	}

}
