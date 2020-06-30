package structures.trees;

import java.util.ArrayList;

/*
 * BST for any comparable items.
 * 
 * Items can be added and removed at any time.
 * Can't contain same Objects (pointers)
 */

public class BST <E extends Comparable<E>> extends Tree {
	private Node<E> root;
	
	private static class Node <E extends Comparable<E>> {
		Node<E> infEq_child, sup_child;
		boolean marked = false;
		E data;
		
		public Node(E data) {
			this.data = data;
		}
		
		public String toString() {
			return data.toString();
		}
	}
	
	public BST() {}
	
	public void add(E data) {
		if (root == null) {
			root = new Node<E>(data);
			return;
		}
		root = insert(data, root);
	}
	
	private Node<E> insert(E data, Node<E> node) {
		if(node == null)
			return new Node<E>(data);
		if(data.compareTo(node.data) > 0)
			node.sup_child = insert(data, node.sup_child);
		else if (data.compareTo(node.data) <= 0 && data != node.data) //Not same item
			node.infEq_child = insert(data, node.infEq_child);
		return node;
	}
	
	public E find(E elem) {
		return find(elem, root);
	}
	
	public ArrayList<E> findAll(E data) {
		ArrayList<E> e = new ArrayList<E>();
		return findAll(data, root, e);
	}
	
	//Return the first matching result.
	private E find(E data, Node<E> node) {
		if(node == null)
			return null;
		if(data.compareTo(node.data) == 0)
			return node.data;
		else if(data.compareTo(node.data) > 0)
			return find(data, node.sup_child);
		else
			return find(data, node.infEq_child);
	}
	
	private ArrayList<E> findAll(E data, Node<E> node, ArrayList<E> list) {
		if(node == null)
			return list;
		if(data.compareTo(node.data) == 0) {
			while(data.compareTo(node.data) == 0) {
				list.add(node.data);
				node = node.infEq_child;
				if(node==null)
					break;
			}
			return list;
		}
		else if(data.compareTo(node.data) > 0)
			return findAll(data, node.sup_child, list);
		else
			return findAll(data, node.infEq_child, list);
	}
	
	public E remove(E elem) {
		return remove(elem, null, root);
	}
	
	private E remove(E data, Node<E> parent, Node<E> node) {	
		if(node == null)
			return null;
		if(data.compareTo(node.data) == 0 && data.equals(node.data)) {
			E elem = node.data;
			delete(data, parent, node);
			return elem; 
		}
		else if (data.compareTo(node.data) > 0)
			return remove(data, node, node.sup_child);
		else
			return remove(data, node, node.infEq_child);
	}
	
	private void delete(E data, Node<E> parent, Node<E> node) {
		//Is 'node' the infEq_child or sup_child of parent?
		if((parent.sup_child.data).compareTo(node.data) == 0)
			parent.sup_child = findInf(parent, node);
		else
			parent.infEq_child = findInf(parent, node);
	}
	
	private Node<E> findInf(Node<E> parent, Node<E> node) {
		if (node.infEq_child == null) {
			parent.infEq_child = null; //No loops please ! :D
			return node;
		}
		return findInf(node, node.infEq_child);
	}
	
	public String toString() {
		return infix("", root);
	}
	
	private String infix(String s, Node<E> node) {
		if(node.sup_child != null)
			s = infix(s, node.sup_child);
		s += node.data.toString();
		if(node.infEq_child != null)
			s = infix(s, node.infEq_child);
		return s;
	}

	/*
	 * Generic tree functions :
	 */
	
	@Override
	protected Object getRoot() {
		return root;
	}

	@Override
	protected ArrayList<Object> getChild(Object node) {
		@SuppressWarnings("unchecked")
		Node<E> n = (Node<E>) node;
		ArrayList<Object> child = new ArrayList<Object>();
		if(n.infEq_child != null)
			child.add(n.infEq_child);
		if(n.sup_child != null)
			child.add(n.sup_child);
		return child;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void mark(Object node) {
		((Node<E>) node).marked = true;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected boolean isMarked(Object node) {
		return ((Node<E>) node).marked;
	}

	@Override
	protected void resetMarks() {
		resetMarksRec(root);
	}
	
	private void resetMarksRec(Node<E> node) {
		node.marked = false;
		resetMarksRec(node.sup_child);
		resetMarksRec(node.infEq_child);
	}
}
