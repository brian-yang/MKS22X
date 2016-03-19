import java.util.*;

public class Driver {
    public static void main(String[]args){
	ArrayList<Integer> m = new ArrayList<Integer>();
	MyLinkedList n = new MyLinkedList();

	long start, end;

	// ============ARGUMENTS===============
	int arrSize;
	if (args.length > 0) {
	    arrSize = Integer.parseInt(args[0]);
	} else {
	    arrSize = 10;
	}
	// ====================================

	for (int i = 0; i < arrSize; i++) {
	    m.add((int) (Math.random() * 100));
	}
	start = System.currentTimeMillis();
	// add(int index, int value) test
	System.out.println("Remove Tests");
	for (int i = 0; i < arrSize; i++) {
	    m.add((int) (Math.random() * m.size()), (int) (Math.random() * 100));
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for ArrayList");

	for (int i = 0; i < arrSize; i++) {
	    n.add((int) (Math.random() * 100));
	}
	start = System.currentTimeMillis();
	// add(int index, int value) test
	System.out.println("Remove Tests");
	for (int i = 0; i < arrSize; i++) {
	    n.add((int) (Math.random() * n.size()), (int) (Math.random() * 100));
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

    }
}
