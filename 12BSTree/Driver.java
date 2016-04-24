public class Driver {
    public static void main(String[] args) {
	BSTree<Integer> bs = new BSTree<Integer>();
	int limit = 100;
	if (args.length > 0) {
	    limit = Integer.parseInt(args[0]);
	}
	for (int i = 0; i < limit; i++) {
	    bs.add(i);
	}
	System.out.println(bs.getHeight());
	System.out.println(bs.contains(100));
	System.out.println(bs.contains(-1));
	System.out.println(bs.contains(9000));
	//System.out.println(bs);
    }
}
