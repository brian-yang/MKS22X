import java.util.*;

public class MyLinkedList<T> implements Iterable<T> {
    LNode head;
    LNode tail;
    int size;

    public Iterator<T> iterator(){
	//This uses an anonymous class! You don't need to know this.
	return new Iterator<T>() {
	    private LNode current = head;

	    public boolean hasNext() {
		return current != null;
	    }
	    public T next() {
		if (!hasNext()) {
		    throw new NoSuchElementException();
		}
		T value = current.getValue();
		current = current.getNext();
		return value;
	    }
	    public void remove() {
		throw new UnsupportedOperationException();
	    }
	};
    }

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

    public String toString(){
	String ans = "[";
	LNode p = head;
	while (p != null) {
	    ans += p.getValue();
	    if (p.getNext()!=null) {
		ans += ", ";
	    }
	    p = p.getNext();
	}
	return ans + "]";
    }

    public String toString(boolean b){
	return toString() + " head: " + head + ", tail: " + tail;
    }

    public boolean add(T value){
	if(head == null){
	    head = new LNode(value);
	    tail = head;
	}else{
	    tail.setNext(new LNode(value));
	    tail.getNext().setPrev(tail);
	    tail = tail.getNext();
	}
	size++;
	return true;
    }

    public T remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
	}
	LNode temp;
	if(index == 0){
	    temp = head;
	    head = head.getNext();
	    size--;
	    if(head == null){
		tail = null;
	    } else {
		head.setPrev(null);
	    }
	    return temp.getValue();
	}else{
	    LNode p = getNth(index-1);
	    temp = p.getNext();
	    if(tail == temp){
		tail = p;
	    }
	    p.setNext(p.getNext().getNext());
	    if (p.getNext() != null) {
		p.getNext().setPrev(p);
	    }
	    size --;
	    return temp.getValue();
	}
    }

    public boolean add(int index, T value){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	LNode temp = new LNode(value);
	if(index == 0){
	    temp.setNext(head);
	    if (head != null) {
		head.setPrev(temp);
	    }
	    head = temp;
	    if(size==0){
		tail = head;
	    }
	}else{
	    LNode p = getNth(index-1);
	    temp.setNext(p.getNext());
	    if (temp.getNext() != null) {
		temp.getNext().setPrev(temp);
	    }
	    p.setNext(temp);
	    temp.setPrev(p);
	    if(tail.getNext() != null){
		tail=tail.getNext();
	    }
	}
	size++;
	return true;
    }

    public int size(){
	return size;
    }

    public T get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).getValue();
    }

    private LNode getNth(int index){
	//check bounds before calling this method!
	LNode temp = head;
	while(index > 0){
	    temp = temp.getNext();
	    index --;
	}
	return temp;
    }

    public T set(int index, T newValue){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).setValue(newValue);
    }

    public int indexOf(T target){
	LNode temp = head;
	int index = 0;
	while(temp != null){
	    if(temp.getValue().equals(target)){
		return index;
	    }
	    index++;
	    temp = temp.getNext();
	}
	return -1;
    }

    private class LNode {
	private T value;
	private LNode next;
	private LNode prev;

	public LNode(T v) {
	    value = v;
	}

	public T getValue() {
	    return value;
	}
	public LNode getNext() {
	    return next;
	}
	public LNode getPrev() {
	    return prev;
	}

	public T setValue(T v) {
	    T old = value;
	    value = v;
	    return old;
	}
	public void setNext(LNode n) {
	    next = n;
	}
	public void setPrev(LNode p) {
	    prev = p;
	}

	public String toString() {
	    return value.toString();
	}
    }
}
