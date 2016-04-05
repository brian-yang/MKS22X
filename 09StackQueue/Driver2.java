import java.util.*;

public class Driver2 {
    public static void main(String[] args) {
	MyLinkedList<Integer> l = new MyLinkedList<>();
	ArrayList<Integer> a = new ArrayList<>();
	// ============ARGUMENTS===============
	int arrSize;
	if (args.length > 0) {
	    arrSize = Integer.parseInt(args[0]);
	} else {
	    arrSize = 10;
	}
	// ====================================
	// add(int value) test
	for (int i = 0; i < arrSize; i++) {
	    Integer n = new Integer((int) (Math.random() * 100));
	    l.add(n);
	    a.add(n);

	    //l.add("Hi");
	}
	System.out.println(l.toString(true));

	System.out.println("Previous Iterator Check");
	Iterator<Integer> it = l.iteratorBack();
	while (it.hasNext()) {
	    System.out.println(it.next());
	}

    // 	// sum(MyLinkedList ll) test
    // 	System.out.println(l);
    // 	System.out.println(a);
    // 	System.out.println(MyLinkedList.sumL(l));
    // 	System.out.println(MyLinkedList.sumA(a));

    	//l.remove(l.size() - 1);
    	l.add(l.size(), 155);
    	//a.remove(a.size() - 1);
    	a.add(a.size(), 155);

    	// // sum(MyLinkedList ll) test #2
    	// System.out.println(l);
    	// System.out.println(a);
    	// System.out.println(MyLinkedList.sumL(l));
    	// System.out.println(MyLinkedList.sumA(a));

    	// toString test
    	System.out.println("toString Test");
    	System.out.println(l.toString(true));
    	System.out.println();

    	// size(), get(int index) tests
    	System.out.println("get tests");
    	for (int i = 0; i < l.size(); i++) {
    	    System.out.println(l.get(i));
    	}
    	System.out.println();

    	// set(int index, int newValue) test
    	System.out.println("set tests");
    	for (int i = 0; i < l.size(); i++) {
    	    System.out.println(l.set(i, new Integer((int) (Math.random() * 100))));
    	    //System.out.println(l.set(i, "works"));
    	}
    	System.out.println(l.toString(true));
    	System.out.println();

    	// indexOf test
    	System.out.println("index of 100");
    	System.out.println(l.indexOf(new Integer(100)));
    	//System.out.println(l.indexOf("works"));
    	System.out.println();

    	// add(int index, int value) test
    	System.out.println("Add Tests");
    	for (int i = 0; i < 1; i++) {
    	    System.out.println( l.add((int) (Math.random() * l.size()), new Integer((int) (Math.random() * 100))) );
    	    a.add((int) (Math.random() * l.size()), new Integer((int) (Math.random() * 100)));
    	    //System.out.println( l.add((int) (Math.random() * l.size()), "works") );
    	    System.out.println(l.toString(true));
    	}
    	System.out.println();

    	// remove(int index) test
    	System.out.println("Remove Tests");
    	for (int i = 0; i < 1; i++) {
    	    //System.out.println( l.remove((int) (Math.random() * l.size())) );
    	    System.out.println( l.remove(0) );
    	    System.out.println(l.toString(true));
    	}
    	System.out.println();

	System.out.println("Previous Iterator Check");
	it = l.iteratorBack();
	while (it.hasNext()) {
	    System.out.println(it.next());
	}

    }
}
