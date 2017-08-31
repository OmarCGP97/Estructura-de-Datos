public class Node<T> {
	public T value;
	public Node<T> prev;
	public Node<T> next;
	
	public Node() {
		value = null;
		prev = this;
		next = this;
	}
	
	public Node(T value) {
		this.value = value;
		prev = this;
		next = this;
	}
}
