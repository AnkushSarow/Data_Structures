/**
 * Testing Quicksort.java
 */

import org.junit.Test;
import java.util.Arrays;
import java.util.Random;

public class QuicksortTest {
    @Test
    public void testQuicksort () {
        Integer[] emptyArray = new Integer[0];
        Integer[] array = new Integer[2];
        Integer[] array2 = new Integer[10];
        String[] array3 = new String[2];
        String[] array4 = new String[5];
        Random rand = new Random();

        Quicksort.sort(emptyArray);

        //Testing sorting on int array with only two values
        array[0] = rand.nextInt(2) + 1;
        array[1] = rand.nextInt(2) + 1;
        System.out.println("Integer array before sorting: " + Arrays.toString(array));
        Quicksort.sort(array);
        System.out.println("Integer array after sorting: " + Arrays.toString(array));

        //Testing sorting on int array with 10 random values ranging from 1 to 10
        for (int i = 0; i < 10; ++i) {
            array2[i] = rand.nextInt(10) + 1;
        }
        System.out.println("Integer array before sorting: " + Arrays.toString(array2));
        Quicksort.sort(array2);
        System.out.println("Integer array after sorting: " + Arrays.toString(array2));

        //Test sorting on string array with only two values
        array3[0] = "AB";
        array3[1] = "AA";
        System.out.println("String array before sorting: " + Arrays.toString(array3));
        Quicksort.sort(array3);
        System.out.println("String array after sorting: " + Arrays.toString(array3));

        //Test sorting on string array with five values
        array4[0] = "C";
        array4[1] = "M";
        array4[2] = "E";
        array4[3] = "B";
        array4[4] = "L";
        System.out.println("String array before sorting: " + Arrays.toString(array4));
        Quicksort.sort(array4);
        System.out.println("String array after sorting: " + Arrays.toString(array4));
    }
}