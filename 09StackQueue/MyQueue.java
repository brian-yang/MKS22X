import java.util.*;

public class MyQueue<T> {
    private MyLinkedList<T> ll;

    public MyQueue() {
	ll = new MyLinkedList<T>();
    }

    public static void main(String[] args) {
	MyQueue<Integer> mq = new MyQueue<Integer>();
	PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	// Test exceptions
	//mq.dequeue();
	//mq.peek();

	// Test functions
	int amount;
	if (args.length > 0) {
	    amount = Integer.parseInt(args[0]);
	} else {
	    amount = 2000000;
	}
	for (int i = 0; i < amount; i++) {
	    int n = (int) (Math.random() * 10000);
	    mq.enqueue(i);
	    q.add(i);
	}
	while (!q.isEmpty() && q.size() == mq.size()) {
	    if ( !(q.peek()).equals(mq.peek()) ) {
		System.out.println("Failed");
		System.exit(0);
	    }
	    if ( !(q.remove()).equals(mq.dequeue()) ) {
		System.out.println("Failed");
		System.exit(0);
	    }
	}
	if (mq.isEmpty()) {
	    System.out.println("Success!");
	} else {
	    System.out.println("Not empty!");
	}
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
