import java.util.*;

public class Quick {
    public static void main(String[] args) {
    	int[] data = new int[40000];
	int[] copy = new int[data.length];
	for (int i = 0; i < data.length; i++) {
	    data[i] = (int) (Math.random() * 10000);
	    copy[i] = data[i];
	}
    	//System.out.println(quickselect(data, Integer.parseInt(args[0])));
    	//System.out.println(Arrays.toString(partition(data, 0, data.length - 1)));
    	quickSort(data);
	Arrays.sort(copy);

	System.out.println("Done! Sorted? " + Arrays.equals(data, copy));
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
    	if (left < right) {
    	    int[] pivots = partition(data, left, right);
    	    quickSort(data, left, pivots[0] - 1);
    	    quickSort(data, pivots[1] + 1, right);
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

    private static int[] partition(int[] data, int left, int right) {
	//System.out.println("Original Array: " + Arrays.toString(data));
	// Random pivot index
	int pivot = (int) (Math.random() * (right - left + 1)) + left;
	//System.out.println("Pivot: " + pivot);
	int[] data2 = new int[data.length];

	// Partition
	int dataIndex = left;
	int indexL = left;
	int indexR = right;

	while (dataIndex <= right) {
	    // System.out.println("Partitioning...");
	    // System.out.println(Arrays.toString(data));
	    // System.out.println("====================");
	    if (data[dataIndex] < data[pivot]) {
		data2[indexL] = data[dataIndex];
		indexL++;
	    } else if (data[dataIndex] > data[pivot]) {
		data2[indexR] = data[dataIndex];
		indexR--;
	    }
	    dataIndex++;
	}
	for (int i = indexL; i <= indexR; i++) {
	    data2[i] = data[pivot];
	}

	// Swap back
	for (int i = left; i <= right; i++) {
	    data[i] = data2[i];
	}

	// Get left index and right index
	int[] indices = new int[2];
	indices[0] = indexL;
	indices[1] = indexR;
	return indices;
    }

    private static void swap(int[] data, int ind1, int ind2) {
	int tmp = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = tmp;
    }
}
