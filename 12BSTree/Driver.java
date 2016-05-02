public class Driver {
    public static void main(String[] args) {
	BSTree<Integer> bs = new BSTree<Integer>();
	int limit = 100;
	if (args.length > 0) {
	    limit = Integer.parseInt(args[0]);
	}
	for (int i = 0; i < limit; i++) {
	    bs.add((int) (Math.random() * 1000));
	}
	bs.add(16);
	bs.add(32);
	bs.add(64);
	bs.add(128);
	bs.add(256);
	System.out.println(bs);
	bs.remove(256);
	System.out.println(bs);
	bs.add(100);
	System.out.println(bs.getHeight());
	System.out.println(bs.contains(100));
	bs.add(9000);
	System.out.println(bs.contains(-1));
	System.out.println(bs.contains(9000));
	System.out.println(bs);
	System.out.println(bs.remove(100));
	System.out.println(bs.getHeight());
	System.out.println(bs);
    }
}
