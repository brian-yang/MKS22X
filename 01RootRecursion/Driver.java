public class Driver {
    public static void main(String[] args) {
	Recursion r = new Recursion();
	System.out.println(r.name());
	//System.out.println(r.sqrt(-10)); // test for exception
	System.out.println(r.sqrt(100));
	System.out.println(r.sqrt(2));
	System.out.println(r.sqrt(625));
    }
}
