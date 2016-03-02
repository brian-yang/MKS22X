public class Sorts {
    private static boolean debug = false;

    public static void printArray(int[] data) {
	String arr = "[";
	for (int i = 0; i < data.length - 1; i++) {
	    arr += Integer.toString(data[i]) + ", ";
	}
	arr += Integer.toString(data[data.length - 1]);
	arr += "]";
	System.out.println(arr);
    }

    // Insertion Sort
    public static void insertionSort(int[] data) {
	for (int i = 1; i < data.length; i++) {
	    int tmp = data[i];
	    int slot = i - 1;
	    while (slot >= 0 && tmp < data[slot]) {
		data[slot + 1] = data[slot];
		slot--;
	    }
	    data[slot + 1] = tmp;
	    // Debug
	    if (debug) {
		printArray(data);
	    }
	}
    }

    // Selection Sort
    public static void selectionSort(int[] data) {
	int min, ind, tmp;
	for (int i = 1; i < data.length; i++) {
	    String combo = findMin(data, i).replace("\n", "");
	    min = Integer.parseInt(combo.split(":")[0]);
	    if (data[i - 1] > min) {
		// swap first index
		tmp = data[i - 1];
		data[i - 1] = min;
		// swap other element
		ind = Integer.parseInt(combo.split(":")[1]);
		data[ind] = tmp;
	    }
	    // Debug
	    if (debug) {
		printArray(data);
	    }
	}
    }

    private static String findMin(int[] data, int index) {
	int min = data[index];
	int minIndex = index;
	for (int i = index; i < data.length; i++) {
	    if (min > data[i]) {
		min = data[i];
		minIndex = i;
	    }
	}
	return Integer.toString(min) + ":" + Integer.toString(minIndex);
    }

    // Bubble Sort
    public static void bubbleSort(int[] data) {
	int tmp;
        for (int counter = data.length; counter >= 0; counter--) {
	    for (int i = 1; i < counter; i++) {
		if (data[i - 1] > data[i]) {
		    swap(data, i, i - 1);
		}
	    }
	    // Debug
	    if (debug) {
		printArray(data);
	    }
	}
    }

    public static void swap(int[] data, int index, int index2) {
	int tmp = data[index];
	data[index] = data[index2];
	data[index2] = tmp;
    }

    public static void fillRandom(int[] data) {
	for (int i = 0; i < data.length; i++) {
	    data[i] = (int) (Math.random() * 10000);
	}
    }
}
Status API Training Shop Blog About Pricing
    public class Sorts {
    private static boolean debug = false;

    public static void printArray(int[] data) {
	String arr = "[";
	for (int i = 0; i < data.length - 1; i++) {
	    arr += Integer.toString(data[i]) + ", ";
	}
	arr += Integer.toString(data[data.length - 1]);
	arr += "]";
	System.out.println(arr);
    }

    // Insertion Sort
    public static void insertionSort(int[] data) {
	for (int i = 1; i < data.length; i++) {
	    int tmp = data[i];
	    int slot = i - 1;
	    while (slot >= 0 && tmp < data[slot]) {
		data[slot + 1] = data[slot];
		slot--;
	    }
	    data[slot + 1] = tmp;
	    // Debug
	    if (debug) {
		printArray(data);
	    }
	}
    }

    // Selection Sort
    public static void selectionSort(int[] data) {
	int min, ind, tmp;
	for (int i = 1; i < data.length; i++) {
	    String combo = findMin(data, i).replace("\n", "");
	    min = Integer.parseInt(combo.split(":")[0]);
	    if (data[i - 1] > min) {
		// swap first index
		tmp = data[i - 1];
		data[i - 1] = min;
		// swap other element
		ind = Integer.parseInt(combo.split(":")[1]);
		data[ind] = tmp;
	    }
	    // Debug
	    if (debug) {
		printArray(data);
	    }
	}
    }

    private static String findMin(int[] data, int index) {
	int min = data[index];
	int minIndex = index;
	for (int i = index; i < data.length; i++) {
	    if (min > data[i]) {
		min = data[i];
		minIndex = i;
	    }
	}
	return Integer.toString(min) + ":" + Integer.toString(minIndex);
    }

    // Bubble Sort
    public static void bubbleSort(int[] data) {
	int tmp;
        for (int counter = data.length; counter >= 0; counter--) {
	    for (int i = 1; i < counter; i++) {
		if (data[i - 1] > data[i]) {
		    swap(data, i, i - 1);
		}
	    }
	    // Debug
	    if (debug) {
		printArray(data);
	    }
	}
    }

    public static void swap(int[] data, int index, int index2) {
	int tmp = data[index];
	data[index] = data[index2];
	data[index2] = tmp;
    }

    public static void fillRandom(int[] data) {
	for (int i = 0; i < data.length; i++) {
	    data[i] = (int) (Math.random() * 10000);
	}
    }
}
