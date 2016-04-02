import java.util.*;

public class MyDeque<T> {
    private MyLinkedList<T> ll;

    public MyDeque() {
	ll = new MyLinkedList<T>();
    }

    public void addFirst(T value) {
	ll.add(0, value);
    }

    public void addLast(T value) {
	ll.add(value);
    }

    public T removeFirst() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return ll.remove(0);
    }

    public T removeLast() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return ll.remove(ll.size() - 1);
    }

    public T getFirst() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return ll.get(0);
    }

    public T getLast() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return ll.get(ll.size() - 1);
    }

    public boolean isEmpty() {
	return ll.size() == 0;
    }
}

