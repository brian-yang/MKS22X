import java.util.*;

public class MyDeque<T> {
    private T[] arr;
    private int size;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public MyDeque() {
	arr = (T[]) new Object[10];
	size = 0;
	head = 0;
	tail = 0;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
	T[] arr2 = (T[]) new Object[arr.length * 2];
	int i = head;
	int j = 0;
	while ( j <= size - 1 && (i <= tail || i >= head) ) {
	    arr2[j] = arr[i];
	    // =============================
	    // Check if i goes out of bounds
	    if (i + 1 > arr.length - 1) {
		i = 0;
	    } else {
		i++;
	    }
	    // =============================
	    j++;
	}
	arr = arr2;
    }

    public void addFirst(T value) {
	if (size + 1 > arr.length) {
	    grow();
	}
	if (head == 0) {
	    head = arr.length - 1;
	} else {
	    head -= 1;
	}
	arr[head] = value;
	size++;
    }

    public void addLast(T value) {
	if (size + 1 > arr.length) {
	    grow();
	}
	if (tail == arr.length - 1) {
	    tail = 0;
	} else {
	    tail += 1;
	}
	arr[tail] = value;
	size++;
    }

    public T removeFirst() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	T value = arr[head];
	if (head == arr.length - 1) {
	    head = 0;
	} else {
	    head += 1;
	}
	size--;
	return value;
    }

    public T removeLast() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
 	T value = arr[tail];
	if (tail == 0) {
	    tail = arr.length - 1;
	} else {
	    tail -= 1;
	}
	size--;
	return value;
    }

    public T getFirst() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return arr[head];
    }

    public T getLast() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return arr[tail];
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public int size() {
	return size;
    }
}
