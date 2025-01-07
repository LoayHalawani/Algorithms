public class BinarySearch {
	
	static int binarySearchIter(int[] arr, int key, int low, int high) {
		while(low <= high) {
			int mid = (int) Math.floor((low + high) / 2);
			if(key == arr[mid]) {
				return mid + 1;
			}
			else if(key < arr[mid]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return 0;
	}

	static int binarySearchRec(int[] arr, int key, int low, int high) {
		if(low > high) {
			return 0;
		}
		int mid = (int) Math.floor((low + high) / 2);
		if(key == arr[mid]) {
			return mid + 1;
		}
		else if(key < arr[mid]) {
			return binarySearchRec(arr, key, low, mid - 1);
		}
		else {
			return binarySearchRec(arr, key, mid + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] arr = {11, 32, 43, 54, 55, 66, 87, 98, 109};
		
		System.out.println("Applying Binary Search iteratively...");
		int index1 = binarySearchIter(arr, 55, 0, arr.length - 1);
		System.out.println("Key 55 found at index: " + index1);

		System.out.println("\nApplying Binary Search recursively...");
		int index2 = binarySearchRec(arr, 55, 0, arr.length - 1);
		System.out.println("Key 55 found at index: " + index2);
	}
}
