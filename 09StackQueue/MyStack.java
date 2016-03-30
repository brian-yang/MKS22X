import java.util.*;

public class MyStack<T> {
    private MyLinkedList<T> ll;

    public MyStack() {
	ll = new MyLinkedList<T>();
    }

    public static void main(String[] args) {
	MyStack<Integer> ms = new MyStack<Integer>();
	Stack<Integer> s = new Stack<Integer>();
	// Test exceptions
	//ms.pop();
	//ms.peek();

	// Test functions
	int amount;
	if (args.length > 0) {
	    amount = Integer.parseInt(args[0]);
	} else {
	    amount = 1000000;
	}
	for (int i = 0; i < amount; i++) {
	    int n = (int) (Math.random() * 10000);
	    ms.push(i);
	    s.push(i);
	}
	while (!s.empty() && s.size() == ms.size()) {
	    if ( !(s.peek()).equals(ms.peek()) ) {
		System.out.println("Failed");
		System.exit(0);
	    }
	    if ( !(s.pop()).equals(ms.pop()) ) {
		System.out.println("Failed");
		System.exit(0);
	    }
	}
	if (ms.isEmpty()) {
	    System.out.println("Success!");
	} else {
	    System.out.println("Not empty!");
	}
    }

    /**
     * Adds the given item to the top of the stack.
     */
    public void push(T item) {
	ll.add(0, item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return ll.remove(0);
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return ll.get(0);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    public int size() {
	return ll.size();
    }

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty() {
	return size() == 0;
    }
}
