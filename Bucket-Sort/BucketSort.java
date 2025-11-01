// Bucket Sort implementation in Java

import java.util.*;

public class BucketSort {
    // Method to perform bucket sort on an array
    public static void bucketSort(float[] arr) {
        if (arr.length == 0) return;

        // Find the maximum and minimum values
        float max = arr[0];
        float min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        // Number of buckets
        int bucketCount = arr.length / 2;
        if (bucketCount < 1) bucketCount = 1;

        // Create buckets
        List<Float>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute elements into buckets
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (int) ((arr[i] - min) / (max - min + 1) * bucketCount);
            if (bucketIndex >= bucketCount) bucketIndex = bucketCount - 1;
            buckets[bucketIndex].add(arr[i]);
        }

        // Sort each bucket and merge
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(buckets[i]);
            for (float num : buckets[i]) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.33f, 0.52f, 0.37f, 0.47f, 0.51f};
        BucketSort.bucketSort(arr);
        System.out.println("Sorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
