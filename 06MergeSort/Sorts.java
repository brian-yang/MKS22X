import java.util.*;

public class Sorts {
    // public static void main(String[] args) {
    // 	int[] test = {262,287, -13461357, -12, 15754561,27,3146,61,17};
    // 	//Sorts.merge(test, 0, 2, 3, 5);
    // 	Sorts.mergeSort(test);
    // 	System.out.println(Arrays.toString(test));
    // }

    public static void mergeSort(int[] data) {
	mergeSortHelper(data, 0, data.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int start, int end) {
	if (end > start) {
	    int startA = start;
	    int endA = (end + start) / 2;
	    int startB = (end + start) / 2 + 1;
	    int endB = end;
	    mergeSortHelper(arr, startA, endA);
	    mergeSortHelper(arr, startB, endB);
	    merge(arr, startA, endA, startB, endB);
	}
    }

    private static void merge(int[] arr, int startA, int endA, int startB, int endB) {
	// used to rewrite arr at the end of this function
	// because startA and startB will have different values
	int tmpStartA = startA;
	int tmpStartB = startB;

	// Merge the two parts of arr
	int[] newArr = new int[endB - startA + 1];
	int index = 0;
	while (startA <= endA && startB <= endB) {
	    if (arr[startA] <= arr[startB]) {
		newArr[index] = arr[startA];
		startA++;
	    } else {
		newArr[index] = arr[startB];
		startB++;
	    }
	    index++;
	}
	if (startA > endA) {
	    for (int i = startB; i <= endB; i++) {
		newArr[index] = arr[i];
		index++;
	    }
	} else if (startB > endB) {
	    for (int i = startA; i <= endA; i++) {
		newArr[index] = arr[i];
		index++;
	    }
	}

	//System.out.println(Arrays.toString(newArr));

	// Rewrite arr
	index = 0;
	for (int i = tmpStartA; i <= endA; i++) {
	    arr[i] = newArr[index];
	    index++;
	}
	for (int i = tmpStartB; i <= endB; i++) {
	    arr[i] = newArr[index];
	    index++;
	}

    }
}
