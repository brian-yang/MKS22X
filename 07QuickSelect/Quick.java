import java.util.*;

public class Quick {
    public static void main(String[] args) {
	int[] data = {0, 10, 100, -15, 20, -2, 1000, 60, 151};
	System.out.println(quickselect(data, 6));
	//System.out.println(partition2(data, 0, data.length - 1));
	System.out.println(Arrays.toString(data));

    }

    public static int quickselect(int[] data, int k) {
	return quickselect(data, k, 0, data.length - 1);
    }

    private static int quickselect(int[] data, int k, int left, int right) {
	int partitionIndex = partition2(data, left, right);
	if (partitionIndex + 1 == k) {
	    return data[partitionIndex];
	}
	return quickselect(data, k, left, partitionIndex - 1);
    }

    private static int partition2(int[] data, int left, int right) {
	int[] data2 = new int[data.length];
	int indexL = left;
	int indexR = right;
	Random rand = new Random();
	int randIndex = rand.nextInt(right - left + 1) + left;

	int dataIndex = left;
	while (dataIndex <= right) {
	    if (dataIndex != randIndex) {
		if (data[dataIndex] <= data[randIndex]) {
		    data2[indexL] = data[dataIndex];
		    indexL++;
		} else if (data[dataIndex] > data[randIndex]) {
		    data2[indexR] = data[dataIndex];
		    indexR--;
		}
	    }
	    dataIndex++;
	}
	// System.out.println();
	// System.out.println(Arrays.toString(data));
	// System.out.println(indexL);
	// System.out.println();


	data2[indexL] = data[randIndex];
	copyBack(data, data2, left, right);
	return indexL;
    }
    private static void copyBack(int[] data, int[] data2, int left, int right) {
	for (int i = left; i <= right; i++) {
	    data[i] = data2[i];
	}
    }

    private static int partition(int[] data, int left, int right) {
	int randIndex = (int) (Math.random() * (right - left + 1)) + left;
	//System.out.println("Random Index: " + randIndex);
	int indexL = left;
	int tmp;
	while (indexL < randIndex) {
	    if (data[indexL] > data[randIndex]) {
		swap(data, indexL, randIndex);
	    }
	    indexL++;
	}
	//if (checkSmaller(data, indexL, right)) {
	swap(data, indexL, right);

	int indexR = right - 1;
	while (indexL < indexR) {
	    //System.out.println("Partitioning.");
	    //System.out.println(Arrays.toString(data));
	    if (data[indexL] > data[right]) {
		swap(data, indexL, indexR);
		indexR--;
	    } else {
		indexL++;
	    }
	}
	if (data[indexL] > data[right]) {
	    swap(data, indexL, right);
	    return indexL;
	} else if (data[indexL] < data[right]) {
	    swap(data, indexL + 1, right);
	    return indexL + 1;
	} else {
	    return indexL;
	}
    }

    private static void swap(int[] data, int ind1, int ind2) {
	int tmp = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = tmp;
    }
}
