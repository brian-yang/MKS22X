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
	size = array.length;
	data = (T[]) new Comparable[size + 1];
	for (int i = 1; i < size + 1; i++) {
	    data[i] = array[i - 1];
	}
	heapify();
    }

    public int size() {
	return size;
    }

    public T peek() {
	return data[1];
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
		if (data[2*k].compareTo(data[2*k + 1]) >= 0) {
		    swapIndex = 2*k;
		} else {
		    swapIndex = 2*k + 1;
		}
		// checks if value should be pushed down
		if (data[k].compareTo(data[swapIndex]) < 0) {
		    swap(k, swapIndex);
		    pushDown(swapIndex); // recursive call
		}
	    } else {
		// checks if value should be pushed down
		if (data[k].compareTo(data[2*k]) < 0) {
		    swap(k, 2*k);
		    pushDown(2*k); // recursive call
		}
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
	if (k >= 2) {
	    if (data[k].compareTo(data[k/2]) >= 1) {
		swap(k, k/2);
		pushUp(k/2); // recursive call
	    }
	}
    }

    private void swap(int ind1, int ind2) {
	T tempVal = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = tempVal;
    }

    private void heapify() {
	for (int i = size/2; i > 0; i--) {
	    pushDown(i);
	}
    }

    // delete the root
    public T delete() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T oldValue = data[1];
	if (size == 1) {
	    data[1] = null;
	    return oldValue;
	}
	data[1] = data[size];
	data[size] = null;
	size--;
	pushDown(1);
	return oldValue;
    }

    public void add(T x) {
	if (size + 1 > data.length - 1) {
	    doubleSize();
	}
	data[size + 1] = x;
	pushUp(size + 1);
	size++;
    }

    private void doubleSize() {
	T[] newData = (T[]) new Comparable[data.length * 2];
	for (int i = 1; i < size + 1; i++) {
	    newData[i] = data[i];
	}
	data = newData;
    }

    public String toString() {
	return Arrays.toString(data);
    }

    public MyHeap(boolean isMax) {}
    public MyHeap(T[] array, boolean isMax) {}
}
