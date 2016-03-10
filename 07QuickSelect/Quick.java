import java.util.*;

public class Quick {
    // public static void main(String[] args) {
    // 	int[] data = {0, 10, 100, -15, 20, -2, 1000, 60, 151};
    // 	System.out.println(quickselect(data, 9));
    // 	//System.out.println(partition(data, 0, data.length - 1));
    // 	System.out.println(Arrays.toString(data));
    // }

    public static String name() {
	return "7,Yang,Brian";
    }

    public static int quickselect(int[] data, int k) {
	return quickselect(data, k - 1, 0, data.length - 1);
    }

    private static int quickselect(int[] data, int k, int left, int right) {
	if (data.length > 1) {
	    int partitionIndex = partition(data, left, right);
	    if (partitionIndex == k) {
		return data[partitionIndex];
	    } else if (partitionIndex > k) {
		return quickselect(data, k, left, partitionIndex - 1);
	    } else if (partitionIndex < k) {
		return quickselect(data, k, partitionIndex + 1, right);
	    }
	}
	return 0;
    }

    private static int partition(int[] data, int left, int right) {
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
