import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private LNode head;
    private LNode last;
    private int size;

    public static double sumL(MyLinkedList<Integer> ll) {
	Integer i = 0;
	Iterator<Integer> it = ll.iterator();
	while (it.hasNext()) {
	    i += it.next();
	}
	return ((double) i.intValue());
    }

    public static double sumA(ArrayList<Integer> a) {
	Integer n = 0;
	for (int i = 0; i < a.size(); i++) {
	    n += a.get(i);
	}
	return ((double) n.intValue());
    }

    // BASIC GET AND SET METHODS

    public int size() {
	return size;
    }


    public T get(int index) {
	if (index >= size() || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode cur = head;
	for (int i = 0; i < index; i++) {
	    cur = cur.getNext();
	}
	return cur.getValue();
    }

    public T set(int index, T newValue) {
	if (index >= size() || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode cur = head;
	for (int i = 0; i < index; i++) {
	    cur = cur.getNext();
	}
	T old = cur.getValue();
	cur.setValue(newValue);
	return old;
    }

    // INDEXOF METHOD

    public int indexOf(T value) {
	LNode cur = head;
	int index = 0;
	while (cur != null) {
	    if (cur.getValue().equals(value)) {
		return index;
	    }
	    index++;
	    cur = cur.getNext();
	}
	return -1;
    }

    // ADD AND REMOVE

    public boolean add(int index, T value) {
	// edge cases
	if (index > size() || index < 0) {
	    throw new IndexOutOfBoundsException();
	} else if (index == size()) {
	    return add(value);
	}
	// add at index
	LNode rep = new LNode(value);
	// Connect new node to previous head
	if (index == 0) {
	    rep.setNext(head);
	    head = rep;
	} else {
	    LNode cur = head;
	    int curIndex = 0;
	    while (curIndex < index - 1) {
		cur = cur.getNext();
		curIndex++;
	    }
	    // Set current
	    rep.setNext(cur.getNext());
	    cur.setNext(rep);
	}
	size++;
	return true;
    }

    public T remove(int index) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	// Set head to next node after removed first node
	T oldValue;
	if (index == 0) {
	    oldValue = head.getValue();
	    head = head.getNext();
	} else {
	    LNode cur = head;
	    int curIndex = 0;
	    while (curIndex < index - 1) {
		cur = cur.getNext();
		curIndex++;
	    }
	    if (index == size - 1) {
		last = cur;
	    }
	    // Store old last
	    oldValue = cur.getNext().getValue();
	    // Set current
	    cur.setNext(cur.getNext().getNext());
	}
	size--;
	return oldValue;
    }

    // ADD TO END AND TOSTRING METHODS

    public boolean add(T value) {
	if (head == null) {
	    head = new LNode(value);
	    last = head;
	} else {
	    last.setNext(new LNode(value));
	    last = last.getNext();
	}
	size++;
	return true;
    }

    public String toString() {
	String arr = "[";
	LNode p = head;
	while (p != null){
	    arr += p.getValue();
	    if (p.getNext() != null){
		arr += ", ";
	    }
	    p = p.getNext();
	}
	arr += "]";
	return arr;
    }

    // ================================================
    // ================================================

    /*
     * LLIterator INNER CLASS
     */

    // Iterator
    public Iterator<T> iterator() {
	return new LLIterator();
    }

    private class LLIterator implements Iterator<T> {
	LNode next;

	public LLIterator() {
	    next = head;
	}

	public boolean hasNext() {
	    return next != null;
	}

	public T next() {
	    if (!hasNext()) {
		throw new NoSuchElementException();
	    } else {
		T value = next.getValue();
		next = next.getNext();
		return value;
	    }
	}

	/*
	 * @Override
	 */
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }

    // ================================================
    // ================================================

    /*
     * LNODE INNER CLASS
     */

    private class LNode {
	private T thing;
	private LNode node;

	public LNode(T thing) {
	    this.thing = thing;
	}

	public T getValue() {
	    return thing;
	}

	public void setValue(T thing) {
	    this.thing = thing;
	}

	public LNode getNext() {
	    return node;
	}

	public void setNext(LNode node) {
	    this.node = node;
	}
    }
}
