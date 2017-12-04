package actividaded6;
import java.util.EmptyStackException;

public class Stack<E> implements IStack<E> {
	private LinkedList<E> stack;
	
	public Stack() {
		stack = new LinkedList<E>();
	}
	
	@Override
	public E push(E e) {
		stack.addFirst(e);
		
		return e;
	}

	@Override
	public E pop() {
		if(empty())
			throw new EmptyStackException();
		
		return stack.removeFirst();
	}

	@Override
	public E peek() {
		if(empty())
			throw new EmptyStackException();
		
		return stack.getFirst();
	}

	@Override
	public boolean empty() {
		return stack.isEmpty();
	}

	@Override
	public Object[] toArray() {
		return stack.toArray();
	}
        
        public int size() {
            return (stack.toArray()).length;
        }
        
        public E remove(int index) {
            Stack<E> tmpStack = new Stack<E>();
            if (empty()) {
                return null;
            } else {
                for (int i = 0; i < index; i++) {
                    tmpStack.push(this.pop());
                }
                E removedElement = tmpStack.pop();
                while (!tmpStack.empty()) {
                    this.push(tmpStack.pop());
                }
                return removedElement;
            }
        }
        
        //Problema 12
        public E get(int index) {
            Stack<E> tmpStack = new Stack<E>();
            if (empty()) {
                return null;
            } else {
                for (int i = 0; i < index+1; i++) {
                    tmpStack.push(this.pop());
                }
                E removedElement = tmpStack.pop();
                while (!tmpStack.empty()) {
                    this.push(tmpStack.pop());
                }
                return removedElement;
            }
        }
}
