/**
 * Created by AnkushSarow on 8/16/16.
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Random;

public class MergesortTest {
    @Test
    public void testMergesort () {
        Integer[] emptyArray = new Integer[0];
        Integer[] array = new Integer[2];
        Integer[] array2 = new Integer[15];
        String[] array3 = new String[2];
        String[] array4 = new String[6];
        Random rand = new Random();

        Mergesort.sort(emptyArray);

        //Testing sorting on int array with only two values
        array[0] = rand.nextInt(2) + 1;
        array[1] = rand.nextInt(2) + 1;
        System.out.println("Integer array before sorting: " + Arrays.toString(array));
        Mergesort.sort(array);
        System.out.println("Integer array after sorting: " + Arrays.toString(array));

        //Testing sorting on int array with 10 random values ranging from 1 to 10
        for (int i = 0; i < 15; ++i) {
            array2[i] = rand.nextInt(15) + 1;
        }
        System.out.println("Integer array before sorting: " + Arrays.toString(array2));
        Mergesort.sort(array2);
        System.out.println("Integer array after sorting: " + Arrays.toString(array2));

        //Test sorting on string array with only two values
        array3[0] = "B";
        array3[1] = "A";
        System.out.println("String array before sorting: " + Arrays.toString(array3));
        Mergesort.sort(array3);
        System.out.println("String array after sorting: " + Arrays.toString(array3));

        //Test sorting on string array with five values
        array4[0] = "D";
        array4[1] = "B";
        array4[2] = "A";
        array4[3] = "C";
        array4[4] = "F";
        array4[5] = "E";
        System.out.println("String array before sorting: " + Arrays.toString(array4));
        Mergesort.sort(array4);
        System.out.println("String array after sorting: " + Arrays.toString(array4));
    }
}