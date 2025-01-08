public class BinarySearch {
	
	static int binarySearchIter(int[] arr, int key, int left, int right) {
		while(left <= right) {
			int mid = (int) Math.floor((left + right) / 2);
			if(key == arr[mid]) {
				return mid + 1;
			}
			else if(key < arr[mid]) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return -1;
	}

	static int binarySearchRec(int[] arr, int key, int left, int right) {
		if(left > right) {
			return -1;
		}
		int mid = (int) Math.floor((left + right) / 2);
		if(key == arr[mid]) {
			return mid + 1;
		}
		else if(key < arr[mid]) {
			return binarySearchRec(arr, key, left, mid - 1);
		}
		else {
			return binarySearchRec(arr, key, mid + 1, right);
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
