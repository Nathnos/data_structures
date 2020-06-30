package structures.queues;

/*
 * FIFO queue.
 * 
 * First in, Fist out.
 * Last in, Last out.
 */

public class FIFO<E> extends Queue<E> {
	public void enqueue(E elem) {
		data.addLast(elem);
	}
	
	public E dequeue() {
		return data.removeFirst();
	}
}
