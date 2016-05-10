public class Driver {
    public static void main(String[] args) {
	RunningMedian m = new RunningMedian();
	for (int i = 0; i < 100; i++) {
	    m.add((int) (Math.random() * 100));
	    System.out.println("Left: " + m.getLeft());
	    System.out.println("Size: " + m.getLeft().size());
	    System.out.println("Right: " + m.getRight());
	    System.out.println("Size: " + m.getRight().size());
	    System.out.println("==============================");
	    System.out.println("Median: " + m.getMedian());
	    System.out.println();
	}
    }
}
