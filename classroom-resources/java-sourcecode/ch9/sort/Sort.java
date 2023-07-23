/*
 *  File: Sort.java
 *  Author: Java, Java, Java
 *  Description: This class implements the Insertion Sort
 *   algorithm. 
 */

public class Sort {
    /**
     * insertionSort() sorts the values in arr into ascending order
     * Pre: arr is not null.
     * Post: The values arr[0]...arr[arr.length-1] will be 
     *  arranged in ascending order.
     */
    public void insertionSort(int arr[]) {
        int temp;               // Temporary variable for insertion
        for (int k = 1; k < arr.length; k++)  {  // For each element
            temp = arr[k];                       // Remove it from array
            int i;                            // For larger preceding elements
            for (i = k-1; i >= 0 && arr[i] > temp; i--) 
                arr[i+1] = arr[i];            // Move it right by one
            arr[i+1] = temp;                  // Insert the element
        }
    } // insertionSort()

    /**
     * print() prints the values in an array
     * @param arr -- an array of integers
     */
    public void print(int arr[]) {
        for (int k = 0; k < arr.length; k++)       // For each integer
            System.out.print( arr[k] + " \t ");    //  Print it
        System.out.println();
    } // print()

    /**
     * main() creates a Sort object and uses it to sort an array
     * of integers
     */
    public static void main(String args[]) {
        int intArr[] = { 21, 20, 27, 24, 19 };
        Sort sorter = new Sort();
        sorter.print(intArr);
        sorter.insertionSort(intArr);
        sorter.print(intArr);
    } // main()
} //Sort
