// Insertion Sort implementation in Java

public class InsertionSort {
    // Method to perform insertion sort on an array
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Element to be inserted at the correct position
            int j = i - 1; // Index of the last sorted element

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Main method to test the insertion sort algorithm
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        InsertionSort.insertionSort(arr);
        System.out.println("Sorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
