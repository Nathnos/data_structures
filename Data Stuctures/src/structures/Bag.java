package structures;

import java.util.ArrayList;

public class Bag<E> {
  private static final int STARTING_SIZE = 10;
  protected ArrayList<E> items;
  private int len = 0;

  public Bag(int size) {
    items = new ArrayList<E>(size);
  }

  public Bag() {
	  this(STARTING_SIZE);
  }

  public int len() {
    return len;
  }
  
  public boolean isEmpty() {
	  return len() > 0;
  }

  public void add(E elem) {
	  items.add(elem);
  }

  public E get(int i) {
    return items.get(i);
  }

  public String toString() {
      return items.toString();
  }

}
