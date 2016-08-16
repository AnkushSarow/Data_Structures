/**
 * Practice the implementation of mergesort
 */

public class Mergesort {
    private static Comparable[] temp;

    public static void sort(Comparable[] array) {
        temp = new Comparable[array.length];
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int start, int end) {
        if (start < end) { //Does nothing if the starting index is greater than or equal to the ending index
            int middle = start + (end - start) / 2;

            sort(array, start, middle); //Sort the left sub array
            sort(array, middle + 1, end); //Sort the right sub array
            merge(array, start, middle, end); //Merge the sorted halves
        }
    }

    private static void merge(Comparable[] array, int start, int middle, int end) {
        int i = start;
        int j = middle + 1;

        //Copy elements into temporary array
        for (int k = start; k <= end; k++) {
            temp[k] = array[k];
        }

        int k = start; //Initialize a counter for the array that will be merged into

        while (i <= middle && j <= end) {
            if (temp[i].compareTo(temp[j]) < 0)  {
                array[k++] = temp[i++];
            }
            else {
                array[k++] = temp[j++];
            }

        }
        while (i <= middle) {
            array[k++] = temp[i++];

        }
        while (j <= end) {
            array[k++] = temp[j++];
        }
    }
}
