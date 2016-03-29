public class DriverStack {
    public static void main(String[] args) {
	MyStack<Integer> stack = new MyStack<Integer>();
	if (args.length > 0) {
	    if (args[0].equals("0")) {
		stack.pop();
	    } else if (args[0].equals("1")) {
		stack.peek();
	    }
	} else {
	    // isEmpty()
	    System.out.println(stack.isEmpty());
	}
	// push(T item)
	stack.push(5);
	System.out.println("Pushed 5");
	stack.push(10);
	System.out.println("Pushed 10");
	stack.push(-100);
	System.out.println("Pushed -100");
	// peek()
	System.out.println(stack.peek());
	// size()
	System.out.println(stack.size());
	// pop()
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
    }
}
