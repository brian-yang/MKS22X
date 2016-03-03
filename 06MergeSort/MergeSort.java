public class MergeSort {
    public static void main(String[] args) {}
    public static int[] mergeSort(int[] arr) {}
    private static void merge(int[] arr, int startA, int endA, int startB, int endB) {
	// used to rewrite arr at the end of this function
	// because startA and startB will have different values
	int tmpStartA = startA;
	int tmpStartB = startB;

	if (arr.length == 1) {
	    return arr;
	}

	// Merge the two parts of arr
	int[] newArr = new int[(endA - startA) + (endB - startB)];
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
