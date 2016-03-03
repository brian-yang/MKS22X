public class Sorts {
    public static void main(String[] args) {}
    public static void mergeSort(int[] data) {
	mergeSortHelper(data, 0, data.length);
    }
    public static void mergeSortHelper(int[] arr, int start, int end) {
	if (end - start == 1) {
	    return;
	}
	int startA = 0;
	int endA = arr.length / 2;
	int startB = arr.length / 2 + 1;
	int endB = arr.length - 1;
	mergeSort(arr, startA, endA);
	mergeSort(arr, startB, endB);
	Sorts.merge(arr, startA, endA, startB, endB);
    }
    private static void merge(int[] arr, int startA, int endA, int startB, int endB) {
	// used to rewrite arr at the end of this function
	// because startA and startB will have different values
	int tmpStartA = startA;
	int tmpStartB = startB;

	// Merge the two parts of arr
	int[] newArr = new int[endB - startA + 1];
	int index = 0;
	while (startA != endA || startB != endB) {
	    if (arr[startA] <= arr[startB]) {
		newArr[index] = arr[startA];
		startA++;
	    } else {
		newArr[index] = arr[startB];
		startB++;
	    }
	    index++;
	}
	if (startA == endA) {
	    for (int i = startB; i < endB; i++) {
		newArr[index] = arr[startB];
		index++;
	    }
	} else {
	    for (int i = startA; i < endA; i++) {
		newArr[index] = arr[startA];
		index++;
	    }
	}

	// Rewrite arr
	index = 0;
	for (int i = tmpStartA; i < endA; i++) {
	    arr[i] = newArr[index];
	    index++;
	}
	for (int i = tmpStartB; i < endB; i++) {
	    arr[i] = newArr[index];
	    index++;
	}

    }
}
