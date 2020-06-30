package structures.trees;

import java.util.ArrayList;

import structures.queues.Stack;

public abstract class Tree {
	protected abstract Object getRoot();
	protected abstract ArrayList<Object> getChild(Object node);
	protected abstract void mark(Object node);
	protected abstract boolean isMarked(Object node);
	protected abstract void resetMarks();
	
	/*
	 * Tree traversal (show all nodes) :
	 */
	
	public void breadth_first_search() {
		Stack<Object> queue = new Stack<Object>();
		Object node = getRoot();
		queue.push(node);
		mark(node);
		while(!queue.isEmpty()) {
			node = queue.pop();
			System.out.print(node + " ");
			for(Object child : getChild(node)) {
				if(!isMarked(child)) {
					queue.push(child);
					mark(child);
				}
			}
		}
		System.out.println();
		
	}
}
