package lab1.collections;

public class LinkedList<E> {

	private Node first;
	private Node last;
	private int count;
	private int capacity;
	
	public LinkedList(int capacity) {
		first = null;
		last = null;
		count = 0;
		this.capacity = capacity;
	}
	
	public int size() {
		return count;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void add(E item) {
		Node node = new Node(item);
		if(last == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
		count++;
		if(count > capacity) {
			first = first.next; //remove the first element
			count--;
		}
	}
	
	public Iterator getIterator() {
		return new LinkedListIterator();
	}
	
	public void sort(Comparator comparator, boolean sortDecreasing) {
		//bubble sort
		int orderModifier = sortDecreasing ? -1 : 1;
		boolean sorted;
		Node current;
		Node prev;
		do {
			sorted = true;
			current = first;
			prev = null;
			while(current.next != null) {
				
				//check if elements are not in the right order
				if(comparator.compare(current, current.next) * orderModifier < 0) {
					sorted = false;
					//swap the 2 nodes
					if(prev != null) {
						prev.next = current.next;
					}
					current.next.next = current;
					current = current.next;
				}
				
				//step to next element
				prev = current;
				current = current.next;
			}
		} while(!sorted);
	}
	
	private class Node {
		
		public E item;
		public Node next;
		
		public Node(E item) {
			this.item = item;
			next = null;
		}
	}
	
	private class LinkedListIterator implements Iterator {
		
		private Node current;
		
		public LinkedListIterator() {
			reset();
		}
		
		public void reset() {
			current = first;
		}
		
		public E getNext() {
			current = current.next;
			return current.item;
		}
		
		public boolean hasNext() {
			return current.next != null;
		}
	}
}
