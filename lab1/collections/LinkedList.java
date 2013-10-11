package lab1.collections;

import java.util.Observable;

public class LinkedList<E> extends Observable {

	private Noeud first;
	private Noeud last;
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
		Noeud node = new Noeud(item);
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
		setChanged();
		notifyObservers();
	}
	
	public Iterator getIterator() {
		return new LinkedListIterator(first);
	}
	
	public void sort(Comparator comparator, boolean sortDecreasing) {
		//bubble sort
		int orderModifier = sortDecreasing ? -1 : 1;
		boolean sorted;
		Noeud current;
		Noeud prev;
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
		setChanged();
		notifyObservers();
	}
	
	private class Noeud {
		
		public E item;
		public Noeud next;
		
		public Noeud(E item) {
			this.item = item;
			next = null;
		}
	}
	
	private class LinkedListIterator implements Iterator {
		
		private Noeud current;
		private Noeud first;
		
		public LinkedListIterator(Noeud first) {
			this.first = first;
			reset();
		}
		
		public void reset() {
			current = first;
		}
		
		public E getNext() {
			E unItem = current.item;
			current = current.next;
			return unItem;
		}
		
		public boolean hasNext() {
			return current != null ;
		}
	}
}
