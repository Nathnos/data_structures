package structures.queues;

/*
 * FILO queue, namely a Stack.
 * First in, Last out.
 * Last in, First out
 */

public class FILO<E> extends Queue<E> {
	public void enqueue(E elem) {
		data.addLast(elem);
	}
	
	public E dequeue() {
		return data.removeLast();
	}
}
