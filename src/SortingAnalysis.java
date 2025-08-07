import java.security.SecureRandom;
import java.util.Arrays;

public class SortingAnalysis {
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        // Define the sizes for each test case
        int[] sizes = {1000, 10000, 100000, 1000000};

        for (int size : sizes) {
            System.out.println("Test Case for size: " + size);

            // Generate a random list of integers
            int[] array = generateRandomArray(size, 2000);

            // Test Merge Sort
            int[] mergeSortArray = Arrays.copyOf(array, array.length);
            long startTime = System.nanoTime();
            mergeSort(mergeSortArray);
            long endTime = System.nanoTime();
            System.out.println("Merge Sort Time: " + (endTime - startTime) / 1e6 + " ms");

            // Test Quick Sort with fixed pivot
            int[] quickSortFixedPivotArray = Arrays.copyOf(array, array.length);
            startTime = System.nanoTime();
            quickSortFixedPivot(quickSortFixedPivotArray, 0, quickSortFixedPivotArray.length - 1);
            endTime = System.nanoTime();
            System.out.println("Quick Sort with Fixed Pivot Time: " + (endTime - startTime) / 1e6 + " ms");

            // Test Quick Sort with random pivot
            int[] quickSortRandomPivotArray = Arrays.copyOf(array, array.length);
            startTime = System.nanoTime();
            quickSortRandomPivot(quickSortRandomPivotArray, 0, quickSortRandomPivotArray.length - 1);
            endTime = System.nanoTime();
            System.out.println("Quick Sort with Random Pivot Time: " + (endTime - startTime) / 1e6 + " ms");

            System.out.println();
        }
    }

    // Method to generate a random array
    private static int[] generateRandomArray(int size, int upperBound) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(upperBound);
        }
        return array;
    }

    // Merge Sort
    private static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            // Split the array into two halves
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            // Recursively sort the two halves
            mergeSort(left);
            mergeSort(right);

            // Merge the sorted halves
            merge(array, left, right);
        }
    }

    // Method to merge two sorted arrays
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Quick Sort with Fixed Pivot (last element as pivot)
    private static void quickSortFixedPivot(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionFixedPivot(array, low, high);
            quickSortFixedPivot(array, low, pivotIndex - 1);
            quickSortFixedPivot(array, pivotIndex + 1, high);
        }
    }

    // Partition method for Quick Sort with Fixed Pivot
    private static int partitionFixedPivot(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    // Quick Sort with Random Pivot
    private static void quickSortRandomPivot(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionRandomPivot(array, low, high);
            quickSortRandomPivot(array, low, pivotIndex - 1);
            quickSortRandomPivot(array, pivotIndex + 1, high);
        }
    }

    // Partition method for Quick Sort with Random Pivot
    private static int partitionRandomPivot(int[] array, int low, int high) {
        int pivotIndex = low + random.nextInt(high - low + 1);
        swap(array, pivotIndex, high); // Move random pivot to the end
        return partitionFixedPivot(array, low, high); // Partition around the random pivot
    }

    // Swap method to swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
