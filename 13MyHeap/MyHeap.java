import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
    private int size;
    private T[] data;

    public MyHeap() {
	size = 1;
	data = (T[]) new Comparable[size];
    }

    public MyHeap(T[] array) {
	size = array.length + 1;
	data = (T[]) new Comparable[size];
	for (int i = 1; i < size; i++) {
	    data[i] = array[i - 1];
	}
	heapify();
    }

    /**pushDown
      precondition: data is a heap with at most one item
      out of place (element at k)
      postconditions:-the element at index k has been 
                     shifted to the correct spot.
                     -data is a valid heap
    **/
    private void pushDown(int k) {
	if (size >= 2*k) {
	    if (size >= 2*k + 1) {
		int swapIndex = 0;
		if (data[2*k] >= data[2*k + 1]) {
		    swapIndex = 2*k;
		} else {
		    swapIndex = 2*k + 1;
		}
		swap(k, swapIndex);
	    } else {
		swap(k, 2*k);
	    }
	}
    }

    /**pushUp
       precondition: data is a heap with at most one item
       out of place (element at k)
       postconditions:-the element at index k has been 
       shifted to the correct spot.
       -data is a valid heap
    **/
    private void pushUp(int k) {
	swap(k, k/2);
    }

    private void swap(int ind1, int ind2) {
	int tempVal = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = tempVal;
    }

    private void heapify() {
	
    }

    // delete the root
    public T delete() {}

    public void add(T x) {}
    private void doubleSize() {}
    public String toString() {}

    //do this last
    public MyHeap(boolean isMax) {}
    public MyHeap(T[] array, boolean isMax) {}
}
