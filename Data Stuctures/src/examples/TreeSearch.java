package examples;

import structures.BST;

public class TreeSearch {
	public static void main(String[] args) {
		BST<Action> tree = new BST<Action>();
		tree.add(new Action("Eat", 2000));
		tree.add(new Action("Sleep", 2000));
		tree.add(new Action("Climb", 5000));
		tree.add(new Action("Homework", -10));
		System.out.println(tree.find(new Action(null, -10)));
		System.out.println(tree.findAll(new Action(null, 2000)));
	}
	
	private static class Action implements Comparable<Action> {
		public final String action;
		public final int value;
		public Action(String action, int value) {
			this.action = action;
			this.value = value;
		}
		@Override
		public int compareTo(Action a) {
			if (value > a.value)
				return 1;
			else if(value < a.value)
				return -1;
			return 0;
		}
		public String toString() {
			return action + " : " + value;
		}
	}
}
