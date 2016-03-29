import java.util.*;

public class MyQueue<T> {
    private MyLinkedList<T> ll;

    public MyQueue() {
	ll = new MyLinkedList<T>();
    }

    /**
     * Adds the given item to the rear of the queue.
     */
    public void enqueue(T item) {
	ll.add(item);
    }

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T dequeue() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return ll.remove(0);
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return ll.get(0);
    }

    /**
     * Returns the number of items currently in the queue.
     */
    public int size() {
	return ll.size();
    }

    /**
     * Returns whether the queue is empty or not.
     */
    boolean isEmpty() {
	return size() == 0;
    }
}
