package structures.queues;

import java.util.LinkedList;

/*
 * Queue abstract class, using LinkedList
 */

public abstract class Queue<E> {
	protected LinkedList<E> data;
	
	public Queue() {
		data = new LinkedList<E>();
	}
	
	public abstract void enqueue(E elem);
	public abstract  E dequeue();
	
	public void add(E elem) {
		enqueue(elem);
	}
	
	public void push(E elem) {
		enqueue(elem);
	}
	
	public E remove() {
		return dequeue();
	}
	
	public E pop() {
		return dequeue();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
