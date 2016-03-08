import java.util.*;

public class Quick {
    public static void main(String[] args) {
	int[] data = {0, 10, 3, 16, 20, -5, 100, -15, 20, 1000};
	System.out.println("Partition Index: " + partition(data, 0, data.length - 1));
	System.out.println(Arrays.toString(data));

    }

    //public static int quickselect(int[] data, int k) {}

    private static int partition(int[] data, int left, int right) {
	int randIndex = (int) (Math.random() * right - left + 1) + left;
	System.out.println("Random Index: " + randIndex);
	int indexL = left;
	int tmp;
	while (indexL < randIndex) {
	    if (data[indexL] > data[randIndex]) {
		tmp = data[indexL];
		data[indexL] = data[randIndex];
		data[randIndex] = tmp;
	    }
	    indexL++;
	}
	System.out.println("Left Done!");
	System.out.println(Arrays.toString(data));
	System.out.println("=====================");
	if (checkSmaller(data, indexL, right)) {
	    tmp = data[indexL];
	    data[indexL] = data[right];
	    data[right] = tmp;

	    System.out.println("To the Corner!");
	    System.out.println(Arrays.toString(data));
	    System.out.println("=====================");

	    int indexR = right - 1;
	    while (indexL < indexR) {
		System.out.println("Partitioning.");
		System.out.println(Arrays.toString(data));
		if (data[indexL] > data[indexR]) {
		    tmp = data[indexL];
		    data[indexL] = data[indexR];
		    data[indexR] = tmp;
		    indexR--;
		} else {
		    indexL++;
		}
	    }

	    System.out.println(indexL);
	    System.out.println(right);

	    if (data[indexL] > data[right]) {
		tmp = data[indexL];
		data[indexL] = data[right];
		data[right] = tmp;
		return indexL;
	    }
	    System.out.println("Partitioned!");
	    System.out.println(Arrays.toString(data));
	    System.out.println("=====================");
	    return right;
	} else {
	    return indexL;
	}
    }

    private static boolean checkSmaller(int[] data, int index, int end) {
	for (int i = index; i <= end; i++) {
	    if (data[i] < data[index]) {
		return true;
	    }
	}
	return false;
    }


    //private static int quickselect(int[] data, int k, int left, int right) {}
}
