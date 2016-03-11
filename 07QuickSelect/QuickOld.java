import java.util.*;

public class QuickOld {
    public static void main(String[] args) {
    	int[] data = new int[4000000];
	int[] copy = new int[data.length];
	for (int i = 0; i < data.length; i++) {
	    data[i] = Integer.MIN_VALUE + (int) (Math.random() * Integer.MAX_VALUE);
	    copy[i] = data[i];
	}
    	//System.out.println(quickselectOld(data, Integer.parseInt(args[0])));
    	//System.out.println(partitionOld(data, 0, data.length - 1));
    	quickSortOld(data);
	Arrays.sort(copy);

	System.out.println("Done! Sorted? " + Arrays.equals(data, copy));
    	//System.out.println(Arrays.toString(data));
    }

    public static String name() {
	return "7,Yang,Brian";
    }


    // OLD VERSION OF QUICK SORT

    /* ============
     * QUICK SORT
     * ============
     */
    public static void quickSortOld(int[] data) {
	quickSortOld(data, 0, data.length - 1);
    }

    private static void quickSortOld(int[] data, int left, int right) {
	if (left < right) {
	    int pivot = partitionOld(data, left, right);
	    quickSortOld(data, left, pivot - 1);
	    quickSortOld(data, pivot + 1, right);
	}
    }

    /* ============
     * QUICK SELECT
     * ============
     */
    public static int quickselectOld(int[] data, int k) {
	if (k <= 0) {
	    k = 1;
	}
	return quickselectOld(data, k - 1, 0, data.length - 1);
    }

    private static int quickselectOld(int[] data, int k, int left, int right) {
	int partitionIndex = partitionOld(data, left, right);
	if (partitionIndex == k) {
	    return data[partitionIndex];
	} else if (partitionIndex > k) {
	    return quickselectOld(data, k, left, partitionIndex - 1);
	} else if (partitionIndex < k) {
	    return quickselectOld(data, k, partitionIndex + 1, right);
	}
	return 0;
    }

    private static int partitionOld(int[] data, int left, int right) {
	//System.out.println("Original Array: " + Arrays.toString(data));

	// Check for final value
	if (left == right) {
	    return left;
	}

	// Random pivot index
	int pivot = (int) (Math.random() * (right - left + 1)) + left;
	//System.out.println("Pivot: " + pivot);

	// Move pivot value to corner
	swap(data, pivot, left);

	// Partition
	int indexL = left + 1;
	int indexR = right;
	while (indexL < indexR) {
	    // System.out.println("Partitioning...");
	    // System.out.println(Arrays.toString(data));
	    // System.out.println("====================");
	    if (data[indexL] <= data[left]) {
		indexL++;
	    } else if (data[indexL] > data[left]) {
		swap(data, indexR, indexL);
		indexR--;
	    }
	}

	// if (indexL != indexR) {
	//     System.out.println("Error!");
	// }


	if (data[indexL] > data[left]) {
	    swap(data, indexL - 1, left);
	    return indexL - 1;
	}
	swap(data, indexL, left);
	return indexL;
    }

    private static void swap(int[] data, int ind1, int ind2) {
	int tmp = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = tmp;
    }
}
