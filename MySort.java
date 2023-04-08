/*
 * Tom Chiapete
 * January 26, 2006
 * Cs340 - Data Structures and Algorithms
 * Assignment #1
 * 
 * Assignment Description
 * This is an implementation of the QuickSort Algorithm.
 * I derived the code from pseudocode from an earlier java book. 
 * This sort routine is dependent on a good pivot point in which 
 * swaps can be made.  I tried my best to get a decent pivot point.
 * 
 * I tweaked this as much as I could, eliminating any unnecessary
 * variables and assignments
 * 
 * No constructor is needed since we are always calling this as a
 * static method.
 * 
 * Results from Lab Machines  
 * Through many trials--
 * Average on unsorted before reaching 1 second: 3200000
 * Best on unsorted before reaching 1 second:  3400000
 * 
 * Known bugs:  None.
 * It appears that everything is sorting correctly.
 */

public class MySort
{
    
    // Instance variables
    private static int [] arr;  // holds our array
    
    /**
     * sort() method
     * This method takes in one parameter, an integer array.
     * It is used as an instance variable.
     * Then make a call to the quicksort() method with a start point of
     * the beginning 0 and and end point of the last index of the array.
     */
    public static void sort(int [] array)
    {
        arr = array;
        
        // Start the sort by having the low point as 0, 
        // the beginning of the array, and n-1 as the 
        // high point of the array.
        quickSort(0, arr.length - 1 );   
    }
    
    
    /**
     * quickSort() method
     * This is a recursive method that takes in two parameters,
     * a low integer and a high integer.
     * If the lowInt parameter is less than the highInt parameter, 
     * then calculate the partition integer.  Call the first listed quickSort() 
     * method with the lowInt as lowInt, and that new partition int as 
     * the high point.  Next call the second listed quickSort() method with 
     * the partition integer as the lowInt, and highInt as the highInt.
     */
    private static void quickSort(int lowInt, int highInt)
    {
        if (lowInt < highInt)
        {
            // Find the partition int
            int partitionInt = partition(lowInt,highInt);
            
            // Recursively run the quicksort methods
            quickSort(lowInt, partitionInt);
            quickSort(partitionInt + 1, highInt);
        }
    }
    
    /**
     * partition() method
     * This method takes in two parameters- a low integer and a high integer.
     * With those two integers, generate a pivot point.
     * Create two variables that will hold the positions which will be compared 
     * in the conditional statements below.
     * We need to swap positions when the lower is less than the 'higher' variable.
     * 
     * The partition value should be the value found in the 'higher' variable.
     */
    private static int partition(int lowInt, int highInt)
    {
        
        // I was experimenting with pivot points.  It seems like I get
        // slightly better results with taking the high and low indexes
        // in the array then dividing it by two to get the average.
        // Another pivot:  int pivot = arr[low];
        int pivot = (arr[lowInt] + arr[highInt]) / 2;
        
        // I need to create two variables as reference points.
        int lower = lowInt - 1;
        int higher = highInt + 1;
        
        // When lower is lower than higher, we must run through a while loop.
        while (lower<higher)
        {
            
            // First, increment the lower value.  And then while the position in
            // the array at the 'lower' position is less than the pivot value, 
            // raise the 'lower' value.
            lower++;
            while (arr[lower] < pivot)
                lower++;
                
            // Next, we have to decrement the 'higher' value.  And then while the 
            // the position at the 'higher' position is greater than the pivot value, 
            // decrement the 'higher' value.
            higher--;
            while (arr[higher] > pivot)
                higher--;
                
            // In order to make this algorithm effective, we have to swap values for 
            // when the 'lower' value is less than the 'higher' value.
            // I set up a simple swap using a temporary variable.
            if (lower < higher)
            {
                int temp1 = arr[lower];
                arr[lower] = arr[higher];
                arr[higher] = temp1;
            }
        }
        // Return the value of what is in the higher variable.
        return higher;
    }
    
}        


