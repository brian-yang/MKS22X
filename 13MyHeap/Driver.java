import java.util.*;

public class Driver {
    public static void main(String[] args) {
	// Integer[] arr = new Integer[10];
	// for (int i = 0; i < 10; i++) {
	//     arr[i] = (int) (Math.random() * 100);
	// }
	// System.out.println(Arrays.toString(arr));
	MyHeap<Integer> h = new MyHeap<Integer>();
	System.out.println(h.size());
	System.out.println(h);
	h.add(15);
	h.add(20);
	h.add(100);
	System.out.println(h);
	h.remove();
	h.add(300);
	System.out.println(h);
	System.out.println(h.size());
	h.remove();
	System.out.println(h);
    }
}
