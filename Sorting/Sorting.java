import java.util.Arrays;

public class Sorting {

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Bubble Sort - O(n^2)
	private static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i ++) {
			for(int j = 0; j < arr.length - i - 1; j ++) {
				if(arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	// Selection Sort - O(n^2)
	private static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i ++) {
			int minIndex = i;
			for(int j = i + 1; j < arr.length; j ++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	// Insertion Sort - O(n^2)
	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i ++) {
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr, j, j - 1);
				j--;
			}
		}
	}

	// Merge Sort - O(nlogn)
	private static void mergeSort(int[] arr, int left, int right) {
		if(left == right) {
			return;
		}

		int mid = (int) Math.floor((left + right) / 2);

		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		
		merge(arr, left, mid, right);
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int n1 = (mid - left) + 1;
		int n2 = right - mid;

		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];

		for(int i = 0; i < n1; i ++) {
			leftArr[i] = arr[left + i]; 
		}
		for(int i = 0; i < n2; i ++) {
			rightArr[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0, k = left;
		while(i < n1 && j < n2) {
			if(leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i ++;
			}
			else if(leftArr[i] > rightArr[j]) {
				arr[k] = rightArr[j];
				j ++;
			}
			k ++;	
		}

		while(i < n1) {
			arr[k] = leftArr[i];
			i ++;
			k ++;
		}
		while(j < n2) {
			arr[k] = rightArr[j];
			j ++;
			k ++;
		}
	}

	// Quick Sort - O(nlogn)
	private static void quickSort(int[] arr, int left, int right) {
		if(left >= right) {
			return;
		}
		
		int pivot = partition(arr, left, right);
		
		quickSort(arr, left, pivot - 1);
		quickSort(arr, pivot + 1, right);
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left - 1;
		for(int j = left; j < right; j ++) {
			if(arr[j] < pivot) {
				i ++;
				swap(arr, i, j);
			}
		}
		
		i ++;
		swap(arr, i, right);
		
		return i;
	}

	// Heap Sort - O(nlogn)
	private static void heapSort(int[] arr) {
		// Convert tree to Max Heap
		for(int i = (arr.length / 2) - 1; i >= 0; i --) {
			heapify(arr, i, arr.length);
		}

		// Delete from Heap
		int n = arr.length - 1;
		while(n > 0) {
			swap(arr, 0, n);
			heapify(arr, 0, n);
			n --;
		}
	}

	private static void heapify(int[] arr, int i, int n) {
		int left = (2 * i) + 1;
		int right = left + 1;

		int max = i;

		if(left < n && arr[left] > arr[max]) {
			max = left;
		}

		if(right < n && arr[right] > arr[max]) {
			max = right;
		}

		if(max > i) {
			swap(arr, i, max);
			heapify(arr, max, n);
		}
	}

	// Driver
	public static void main(String[] args) {
		int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

		System.out.print("Array: ");
		System.out.println(Arrays.toString(arr));

		System.out.println("\nSorting...");
		
		bubbleSort(arr);
		selectionSort(arr);
		insertionSort(arr);
		mergeSort(arr, 0, arr.length - 1);
		quickSort(arr, 0, arr.length - 1);
		heapSort(arr);
		
		System.out.print("\nArray: ");
		System.out.println(Arrays.toString(arr));
	}
} 