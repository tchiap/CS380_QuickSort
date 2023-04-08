/*
 * TestSort.java
 *   This class contains a test harness and some utility methods to
 *   support students' sorting algorithms.
 *
 * Written by: Stuart Hansen
 * Date: January 13, 2006
 *
 */

import java.util.*;
import java.io.*;

public class TestSort {

    public static void main (String args[]) throws Throwable
    {
        // Sort and print a few small arrays to make certain the sort works
        for (int size = 10; size<30; size+=10) {
        
            int [] array = createRandomArray(size);
            System.gc();
           

            long startTime = System.nanoTime();
            MySort.sort(array);
            long endTime = System.nanoTime();

            System.out.println ("Sort time = " +
                                 (endTime-startTime)/1000000000.0 + 
                                 " seconds");
            for (int i=0; i<size; i++)
                System.out.print(array[i] + " ");
            System.out.println("\n");
    }

        // Sort and time larger arrays        100000
        for (int size = 1000000; size<10000000; size+=100000) {
        
            int [] array = createRandomArray(size);
            System.gc();

            long startTime = System.nanoTime();
            MySort.sort(array);
            long endTime = System.nanoTime();

            System.out.println ("Array size = " + size + " Sort time = " +
                                 (endTime-startTime)/1000000000.0 + 
                                 " seconds");
    }


    }


    // This method reads creates an array of random integers
    public static int[] createRandomArray(int size) throws Throwable
    {
    int [] array = new int [size];

        for (int i=0; i<size; i++) array[i] = i;

        Random r = new Random();
        for (int j=0; j<size; j++) {
            int i = r.nextInt(size);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
    }    

        return array;
    }
}
