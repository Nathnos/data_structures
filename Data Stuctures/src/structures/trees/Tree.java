package structures.trees;

import java.util.ArrayList;

import structures.queues.FIFO;

/*
 * 
 */

public abstract class Tree {
	protected abstract Object getRoot();
	protected abstract ArrayList<Object> getChild(Object node);
	protected abstract void mark(Object node);
	protected abstract boolean isMarked(Object node);
	protected abstract void resetMarks();
	
	/*
	 * Tree traversal (show all nodes) :
	 * Breadth-first and Depth-first search (
	 */
	
	public void breadth_first_search() {
		FIFO<Object> queue = new FIFO<Object>();
		Object node = getRoot();
		resetMarks();
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
	
	public void depth_first_search_pre() {
		depth_first_search_pre_rec(getRoot());
		System.out.println();
	}
	
	public void depth_first_search_pre_rec(Object node) {
		System.out.print(node + " ");
		for(Object child : getChild(node))
			depth_first_search_pre_rec(child);
	}
	

	public void depth_first_search_in() {
		depth_first_search_in_rec(getRoot(), 1);
		System.out.println();
	}
	
	public void depth_first_search_in(int n) {
		//Show node after n children
		depth_first_search_in_rec(getRoot(), n);
		System.out.println();
	}
	
	public void depth_first_search_in_rec(Object node, int n) {
		//Show current node after n children
		ArrayList<Object> children = getChild(node);
		int size = children.size();
		if(n>size) {
			for(Object child : children)
				depth_first_search_in_rec(child, n);
			System.out.print(node + " ");
		}
		else {
			for(int i = 0; i<n; i++)
				depth_first_search_in_rec(children.get(i), n);
			System.out.print(node + " ");
			for(int i = n; i<size; i++)
				depth_first_search_in_rec(children.get(i), n);
		}
	}
	

	public void depth_first_search_post() {
		depth_first_search_post_rec(getRoot());
		System.out.println();
	}
	
	public void depth_first_search_post_rec(Object node) {
		for(Object child : getChild(node))
			depth_first_search_post_rec(child);
		System.out.print(node + " ");
	}
	
}
