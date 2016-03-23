public class Driver2 {
    public static void main(String[] args) {
	MyLinkedList<String> l = new MyLinkedList<String>();
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
	    //l.add(new Integer((int) (Math.random() * 100)));
	    l.add("Hi");
	}

	// toString test
	System.out.println("toString Test");
	System.out.println(l);
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
	    //System.out.println(l.set(i,
	    //new Integer((int) (Math.random() * 100))));
	    System.out.println(l.set(i, "works"));
	}
	System.out.println(l);
	System.out.println();

	// indexOf test
	System.out.println("index of 100");
	//System.out.println(l.indexOf(new Integer(100)));
	System.out.println(l.indexOf("works"));
	System.out.println();

	// add(int index, int value) test
	System.out.println("Add Tests");
	for (int i = 0; i < 1; i++) {
	    //System.out.println( l.add((int) (Math.random() * l.size()), new Integer((int) (Math.random() * 100))) );
	    System.out.println( l.add((int) (Math.random() * l.size()), "Testing") );
	    System.out.println(l);
	}
	System.out.println();

	// remove(int index) test
	System.out.println("Remove Tests");
	for (int i = 0; i < 1; i++) {
	    //System.out.println( l.remove((int) (Math.random() * l.size())) );
	    System.out.println( l.remove(0) );
	    System.out.println(l);
	}
	System.out.println();
    }
}
