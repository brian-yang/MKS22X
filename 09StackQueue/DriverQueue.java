public class DriverQueue {
    public static void main(String[] args) {
	MyQueue<Integer> q = new MyQueue<Integer>();
	if (args.length > 0) {
	    if (args[0].equals("0")) {
		q.dequeue();
	    } else if (args[0].equals("1")) {
		q.peek();
	    }
	} else {
	    // isEmpty()
	    System.out.println(q.isEmpty());
	}
	// enqueue(T item)
	q.enqueue(5);
	System.out.println("Enqueued 5");
	q.enqueue(10);
	System.out.println("Enqueued 10");
	q.enqueue(-100);
	System.out.println("Enqueued -100");
	// peek()
	System.out.println(q.peek());
	// size()
	System.out.println(q.size());
	// dequeue()
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
    }
}
