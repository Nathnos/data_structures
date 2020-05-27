package structures;

/*
 * BST for any comparable items.
 * 
 * Items can be added and removed at any time.
 * Can't contain similar items - by equals() standard method
 */

public class BST <E extends Comparable<E>> {
	private Node<E> root;
	
	private static class Node <E extends Comparable<E>> {
		Node<E> infEq_child, sup_child;
		E data;
		
		public Node(E data) {
			this.data = data;
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
		else if (data.compareTo(node.data) == 0 && !data.equals(node.data)) //Not same item
			node.infEq_child = insert(data, node.infEq_child);
		return node;
	}
	
	public E find(E elem) {
		return find(elem, root);
	}
	
	//TODO findAll : renvoie une ArrayList
	
	//Return the first matching result.
	private E find(E data, Node<E> node) {
		if(node == null)
			return null;
		System.out.println("FIND : " + node.data + (node.infEq_child == null) + (node.sup_child == null)
		+ data.compareTo(node.data));
		if(data.compareTo(node.data) == 0)
			return node.data;
		else if(data.compareTo(node.data) > 0)
			return find(data, node.sup_child);
		else
			return find(data, node.infEq_child);
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
	
}
