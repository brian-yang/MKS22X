public class Driver {
    public static void main(String[] args) {
	Frontier<Integer> frs = new FrontierStack<Integer>();
	Frontier<Integer> frq = new FrontierQueue<Integer>();
	// Frontier Stack
	int size = 100;
	for (int i = 0; i < size; i++) {
	    frs.add((int) (Math.random() * 100));
	}
	System.out.println(frs);
	while (frs.hasNext()) {
	    System.out.println(frs.next());
	}
	System.out.println("[" + frs + "]");
	System.out.println(frs.hasNext());

	System.out.println();
	System.out.println("==============================");
	System.out.println();

	// Frontier Queue
	for (int i = 0; i < size; i++) {
	    frq.add((int) (Math.random() * 100));
	}
	System.out.println(frq);
	while (frq.hasNext()) {
	    System.out.println(frq.next());
	}
	System.out.println("[" + frq + "]");
	System.out.println(frq.hasNext());

    }
}
