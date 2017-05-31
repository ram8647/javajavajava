/*
 *  File: TestSort.java
 *  Author: Java, Java, Java, 2E
 *  Description:  This class tests the polymorphic sorting method
 *   by first using it to sort an array of Integers and then to
 *   sort an array of Floats. The key concept is that the array
 *   contains elements that implement java.lang.Comparable interface.
 *   Objects that implement this interface have a compareTo() method
 *   that can be used to determine their order.
 */

public class TestSort {
    public static int MAXSIZE = 25;

    /**
     *  sort() uses the compareTo() method to sort an array of
     *  Comparable objects into ascending order.
     *  @param arr -- an array of objects that implement Comparable
     */
    public static void sort(Comparable[] arr) {
        Comparable temp;                                   // Temporary variable
        for (int pass = 1; pass < arr.length; pass++)      // For each pass
            for (int pair = 1; pair < arr.length ; pair++) // For each pair
                if (arr[pair].compareTo(arr[pair-1]) < 0) { //   Compare 
                    temp = arr[pair-1];                     //   and swap
                    arr[pair-1] = arr[pair];
                    arr[pair] = temp;               
                } // if
    } // sort()

    /**
     *  prints() an array 5 objects per line
     *  @param arr -- an array of objects that implement Comparable
     */
    public static void print(Comparable arr[]) {
        for (int k = 0; k < arr.length; k++) { 
            if (k % 5 == 0)  System.out.println();        // New row
            System.out.print(arr[k].toString() + "\t");
        }
        System.out.println();
    }
        
    /**
     *  main() creates both an Integer and Float array and then uses
     *   the polymorphic sort() method to sort them.
     */
    public static void main(String args[]) {
        Integer iArr[] = new Integer[MAXSIZE]; // The Integer array
        Float fArr[] = new Float[MAXSIZE];   // The Float array

        // Populate each array with randomly generated objects
        for (int k = 0; k < MAXSIZE; k++) {
            iArr[k] = new Integer((int) (Math.random() * 10000));
            fArr[k] = new Float(Math.random() * 10000);
        }
       
	sort(iArr);     // Sort and print each array
        print(iArr);
	sort(fArr); 
        print(fArr);                      
	//        java.util.Arrays.sort(anArr);                             // Sort the array
    } // main()
} 
