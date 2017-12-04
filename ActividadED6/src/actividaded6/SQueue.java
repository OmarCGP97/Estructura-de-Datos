package actividaded6;
import java.util.NoSuchElementException;
/**
 *
 * @author Omar Castañeda
 */
public abstract class SQueue<E> implements IQueue<E> {

	private Stack<E> stack1;
	private Stack<E> stack2;

	public SQueue() {
		stack1 = new Stack<E>();
		stack2 = new Stack<E>();
	}

	@Override
	public void offer(E e) {
		stack1.push(e);
	}

	@Override
	public E remove() {
		if (stack1.empty()) {
			for (int i = 0; i<stack2.size(); i++) {
				stack1.push(stack2.pop());
			}
		}
		return stack1.pop();
	}

	@Override
	public E element() {
		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
		
	}

	@Override
	public int size() {
		return stack1.size();
	}

	@Override
	public boolean isEmpty() {
		return stack1.empty();
	}

	@Override
	public void clear() {
		while(!stack1.empty()){
                    stack1.pop();
                }
	}

	@Override
	public String toString() {
		return new StringBuilder(stack1.toString()).reverse().toString();
	}

}