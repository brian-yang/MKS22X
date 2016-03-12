import java.util.*;

public class Quick {
    public static void main(String[] args) {
    	int[] data = new int[4000000];
	int[] copy = new int[data.length];
	for (int i = 0; i < data.length; i++) {
	    data[i] = Integer.MIN_VALUE + (int) (Math.random() * 2 * Integer.MAX_VALUE);
	    copy[i] = data[i];
	}
    	//System.out.println(Arrays.toString(partition(data, 0, data.length - 1)));
	// System.out.println(Arrays.toString(data));
	// for (int i = 0; i < 1; i++) {
	//     System.out.println(quickselect(data, i));
	// }
	if (args.length > 0) {
	    if (Integer.parseInt(args[0]) == 1) {
		quickSort(data);
	    } else if (Integer.parseInt(args[0]) == 2) {
		Arrays.sort(copy);
	    } else {
		quickSort(data);
		Arrays.sort(copy);
		System.out.println("Done! Sorted? " + Arrays.equals(data, copy));
	    }
	}
    	//System.out.println(Arrays.toString(data));
    }

    public static String name() {
	return "7,Yang,Brian";
    }

    /* ============
     * QUICK SORT
     * ============
     */
    public static void quickSort(int[] data) {
    	quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] data, int left, int right) {
    	int[] pivots = partition(data, left, right);
    	if (left < right) {
	    if (pivots[0] - 1 > left) {
		quickSort(data, left, pivots[0] - 1);
	    }
	    if (pivots[1] + 1 < right) {
		quickSort(data, pivots[1] + 1, right);
	    }
    	}
    }

    /* ============
     * QUICK SELECT
     * ============
     */
    public static int quickselect(int[] data, int k) {
	if (k <= 0) {
	    k = 1;
	}
	return quickselect(data, k - 1, 0, data.length - 1);
    }

    private static int quickselect(int[] data, int k, int left, int right) {
	int[] partitionIndex = partition(data, left, right);
	if (partitionIndex[0] <= k && partitionIndex[1] >= k) {
	    return data[partitionIndex[0]];
	} else if (partitionIndex[0] > k) {
	    return quickselect(data, k, left, partitionIndex[0] - 1);
	} else if (partitionIndex[1] < k) {
	    return quickselect(data, k, partitionIndex[1] + 1, right);
	}
	return 0;
    }

    /* ============
     * PARTITION
     * ============
     */
    private static int[] partition(int[] data, int left, int right) {
	// Random pivot index
	int pivot = (int) (Math.random() * (right - left + 1)) + left;
	int[] data2 = new int[right - left + 1]; // size of data2 is important if data is very large

	// Partition
	int indexL = 0;
	int indexR = right - left;

	for (int dataIndex = left; dataIndex <= right; dataIndex++) {
	    if (data[dataIndex] < data[pivot]) {
		data2[indexL] = data[dataIndex];
		indexL++;
	    } else if (data[dataIndex] > data[pivot]) {
		data2[indexR] = data[dataIndex];
		indexR--;
	    }
	}

	for (int i = indexL; i <= indexR; i++) {
	    data2[i] = data[pivot];
	}

	// To be added to indexL and indexR
	int startIndex = left;

	// Swap back
	for (int i = 0; i < data2.length; i++) {
	    data[startIndex] = data2[i];
	    startIndex++;
	}

	// Get left index and right index
	int[] indices = new int[2];
	indices[0] = indexL + left;
	indices[1] = indexR + left;
	return indices;
    }

    private static void swap(int[] data, int ind1, int ind2) {
	int tmp = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = tmp;
    }

}
