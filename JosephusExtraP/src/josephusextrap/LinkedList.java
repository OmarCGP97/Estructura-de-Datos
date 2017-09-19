package josephusextrap;

import java.util.NoSuchElementException;
import java.util.*;

public class LinkedList<E> implements List<E> {
	private Node<E> header;
	private int size;
	
	public LinkedList() {
		header = new Node<E>();
		size = 0;
	}
	
	/**
	 * Gets the node at the specified index.
	 * @param index the index of the node to get
	 * @return the node at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	private Node<E> node(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index < (size >> 1)) {
            Node<E> x = header.next;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = header.prev;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
	}

	@Override
	public void addFirst(E e) {
		Node<E> newList = new Node<E>(e);
		newList.next=header.next;
                newList.prev=header;
                header.next=newList;
                header.next.prev=newList.next;
		size++;
	}

	@Override
	public void addLast(E e) {
                
		Node<E> newList = new Node<E>(e);
                newList.next=header;
                newList.prev=header.prev;
                header.prev.next=newList;
                header.prev=newList;
                size++;
	}

	@Override
	public void add(int index, E element) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> newNode = new Node<E>(element);
                Node<E> current = header;
                int count=0;
                while(count<index){
                    current=current.next;
                    count++;
                }
                newNode.prev=current;
                newNode.next=current.next.prev;
                current.next=newNode;
                current.next.prev=newNode;
                size++;
	}

	@Override
	public E removeFirst() {
		if(header.next == null) {
			throw new NoSuchElementException();
		}
		
		Node<E> nodeToRemove = header.next;
		header.next=nodeToRemove.next;
                nodeToRemove.next.prev=header;
                nodeToRemove.next=null;
                nodeToRemove.prev=null;
		size--;
		return nodeToRemove.value;
	}

	@Override
	public E removeLast() {
		if(header.next == null) {
			throw new NoSuchElementException();
		}
		
		Node<E> nodeToRemove = header.prev;
                header.prev=nodeToRemove.prev;
                nodeToRemove.prev.next=header;
		size--;
		return nodeToRemove.value;
	}

	@Override
	public E remove(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
                Node<E> current = header;
                int count = 0;
                while(count<index){
                    current=current.next;
                    count++;
                }
                current.next=current.next.next;
                current.next.next.prev=current;
                size--;
		return current.value;
	}

	@Override
	public boolean remove(Object o) {
		Node<E> current = header;
                while(current.next != header){
                    if(current.next.value.equals(o)){
                        current.next=current.next.next;
                        current.next.next.prev=current;
                        size--;
                        return true;
                    }
                    current = current.next;
                }
		return false;
	}

	@Override
	public E getFirst() {
		if(header.next == null) {
			throw new NoSuchElementException();
		}
		
		return header.next.value;
	}

	@Override
	public E getLast() {
		if(header.next == null) {
			throw new NoSuchElementException();
		}
		
		Node<E> current = header.next;
		while(current.next != header)
			current = current.next;
		
		return current.value;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
                Node<E> current = header;
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
		Node<E> newNode = new Node<E>(element);
                Node<E> previous = header;
                int count=0;
                while(count<index){
                    previous=previous.next;
                    count++;
                }
                previous.next=previous.next.next;
                previous.next.next.prev=previous;
                
                Node<E> current = header;
                for(int i=0;i<index;i++){
                    current=current.next;
                }
                newNode.prev=current;
                newNode.next=current.next.prev;
                current.next=newNode;
                current.next.prev=newNode;
                size++;
                return previous.value;
	}

	@Override
	public boolean contains(E e) {
		Node<E> current = header;
                while(current.next != header){
                    if(current.value==e){
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
			for(Node<E> x = header.next; x != header; x = x.next) {
				if(x.value == null)
					return index;
				index++;
			}
		}
		else {
                    for(Node<E> x=header.next; x != header; x=x.next){
                        if(x.value ==null)
                            return index;
                        index++;
                    }    
		}
                return -1;
	}

	@Override
	public void clear() {
		header.next = null;
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
		Object[] array = new Object[size-1];
                int i=0;
                for(Node<E> x=header.next;x!=header; x=x.next)
                    array[i++]=x.value;
                
            return array;
	}
	
	@Override
	public String toString() {
		if(header.next == null){
			return "[]";
                }
		Node<E> current = header.next;
		String returnValue = "[" + current.value;
		while(current.next != header) {
			current = current.next;
			returnValue += ", " + current.value;
		}
		
		returnValue += "]";
                if(returnValue=="[null]"){
                    returnValue="[]";
                }
		return returnValue;
	}
        
        public void josephus(int steps){
            Node<E> currentNode = header;
            Node<E> previousNode = header;
            Node<E> nextNode = header;
            
            System.out.println();
            System.out.println("Lista Inicial de Elementos: "+toString());
            System.out.println("Se elemiminara al elemento que este cada "+steps+" pasos.");
            
            System.out.println();
            
            while(size()!=1){
                for(int i=0; i<=steps; i++){
                    currentNode=currentNode.next;
                    if(currentNode.value==null){
                        currentNode = currentNode.next;
                    }
                }
                previousNode=currentNode.prev;
                nextNode=currentNode.next;
                previousNode.next=nextNode;
                nextNode.prev=previousNode;
                currentNode.prev=null;
                size--;
                
            System.out.println("Se ha elminado al elemento "+currentNode.value+".");
            System.out.println("Elementos Restantes: "+toString());
            System.out.println();
            
            }
            System.out.println("Ultimo elemento restante: "+header.next.value+".");
        }
}
