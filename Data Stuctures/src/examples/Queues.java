package examples;

import structures.queues.*;

public class Queues {

	public static void main(String[] args) {
		FILO<Integer> queue = new FILO<Integer>();
		queue.push(Integer.valueOf(1));
		queue.push(Integer.valueOf(2));
		queue.push(Integer.valueOf(3));
		queue.pop();
		queue.push(Integer.valueOf(4));
		System.out.println(queue);
	}

}
