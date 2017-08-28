
import java.util.NoSuchElementException;
import java.util.*;
import javax.swing.text.Element;


public class SLinkedList<E> implements List<E> {
	private SNode<E> top;
	private int size;
	
	public SLinkedList() {
		top = new SNode<E>();
		size = 0;
	}

	@Override
	public void addFirst(E e) {
		SNode<E> newList = new SNode<E>(e);
		newList.next = top.next;
		top.next = newList;
		size++;
	}

	@Override
	public void addLast(E e) {
		SNode<E> newNode = new SNode<E>(e);
		
		SNode<E> current = top;
		while(current.next != null)
			current = current.next;
		
		current.next = newNode;
		size++;
	}

	@Override
	public void add(int index, E element) {
                if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		SNode<E> newNode = new SNode<E>(element);
                SNode<E> previous = top;
                int count=0;
                while(count<index){
                    previous=previous.next;
                    count++;
                }
                SNode current = previous.next;
                newNode.next = current;
                previous.next = newNode;
                size++;
	}

	@Override
	public E removeFirst() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		SNode<E> nodeToRemove = top.next;
		top.next = nodeToRemove.next;
		nodeToRemove.next = null;
		size--;
		return nodeToRemove.value;
	}

	@Override
	public E removeLast() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		SNode<E> current = top;
		while(current.next.next != null)
			current = current.next;
		
		SNode<E> nodeToRemove = current.next;
		current.next = null;
		size--;
		return nodeToRemove.value;
	}

	@Override
	public E remove(int index) {
                if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
                SNode<E> previous = top;
                int count = 0;
                while(count<index){
                    previous=previous.next;
                    count++;
                }
                SNode<E> current = previous.next;
                previous.next = current.next;
                current.next=null;
                size--;
		return current.value;
	}

	@Override
	public boolean remove(Object o) {
		SNode<E> previous = top;
                while(previous != null){
                    if(previous.next.value.equals(o)){
                        SNode<E> current = previous.next;
                        previous.next = current.next;
                        current.next=null;
                        size--;
                        return true;
                    }
                    previous = previous.next;
                }
		return false;
	}

	@Override
	public E getFirst() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		return top.next.value;
	}

	@Override
	public E getLast() {
		if(top.next == null) {
			throw new NoSuchElementException();
		}
		
		SNode<E> current = top.next;
		while(current.next != null)
			current = current.next;
		
		return current.value;
	}

	@Override
	public E get(int index) {
                if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
                SNode<E> current = top;
		if(index < size){
                    for(int i=-1;i<index;i++){
                        current = current.next;
                    }
                }
                return current.value;
	    }   

	@Override
	public E set(int index, E element) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		SNode<E> newNode = new SNode<E>(element);
                SNode<E> previous = top;
                int count=0;
                while(count<index){
                    previous=previous.next;
                    count++;
                }
                SNode current = previous.next;
                newNode.next = current;
                previous.next = newNode;
                SNode actual = top;
                for(int i=0;i<index+1;i++){
                    actual=actual.next;
                }
                SNode<E> current2 = actual.next;
                actual.next = current2.next;
                current2.next=null;
               
                return previous.value;
	    }

	@Override
	public boolean contains(E e) {
            String element=e.toString();
		SNode<E> current = top;
                String values=current.next.value.toString();
                while(current != null){
                    if(values.equals(element)){
                        return true;
                    }
                    current = current.next;
                }
		return false;
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		
		if(o == null) {
			for(SNode<E> x = top.next; x != null; x = x.next) {
				if(x.value == null)
					return index;
				index++;
			}
		}
		else {
                    for(SNode<E> x=top.next; x != null; x=x.next){
                        if(x.value ==null)
                            return index;
                        index++;
                    }    
		}
                return -1;
	}

	@Override
	public void clear() {
		top.next = null;
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
	public Object[] toArray() {
                Object[] array = new Object[size];
                for (int i = 0; i < size; i++) {
                    array[i]=new Object();
            }
            return array;
	}
	
	public String toString() {
		if(top.next == null)
			return "[]";
		
		SNode<E> current = top.next;
		String returnValue = "[" + current.value;
		while(current.next != null) {
			current = current.next;
			returnValue += ", " + current.value;
		}
		
		returnValue += "]";
		return returnValue;
	}
}
