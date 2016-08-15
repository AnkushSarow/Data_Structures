/**
 * Practice the implementation of quicksort
 */

public class Quicksort {

    private Quicksort() {
    }

    /**
     * Sorts a generic array (must be comparable).
     * @param array - The array to be sorted
     */
    public static <T extends Comparable<T>> void sort (T[] array) {
        sort(array, 0, array.length - 1);
    }
    private static<T extends Comparable<T>> void sort(T[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            sort(array, start, pivot - 1);
            sort(array, pivot + 1, end);
        }
    }

    /**
     * Partitions the array such that all elements less than or equal to the pivot (chosen as
     * the last item in the array) of the array will be to the left of the pivot and all items greater than the
     * pivot will be to the right of the pivot
     * @param array - The array to be partitioned
     * @param start - Starting index of the array
     * @param end - Last index of the array
     * @return pivotIndex - The integer value representing the position of the pivot in the array
     */
    private static <T extends Comparable<T>> int partition(T[] array, int start, int end) {
        int pivotIndex = start;
        T pivotItem = array[end];

        for (int i = start; i < end; ++i) {
            if (array[i].compareTo(pivotItem) <= 0) {
                swap(array, i, pivotIndex);
                ++pivotIndex;
            }
        }
        swap(array, pivotIndex, end);
        return pivotIndex;
    }

    private static <T extends Comparable<T>> void swap(T[] array, int index1, int index2) {
        T data = array[index1];
        array[index1] = array[index2];
        array[index2] = data;
    }
}
