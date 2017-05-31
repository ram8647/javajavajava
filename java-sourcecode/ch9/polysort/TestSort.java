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
    public void sort(Comparable[] arr) {
        Comparable temp;               // Temporary variable for insertion
        for (int k = 1; k < arr.length; k++)  {  // For each element
            temp = arr[k];                       // Remove it from array
            int i;
            for (i = k-1; i >= 0 && arr[i].compareTo(temp) > 0; i--) 
                arr[i+1] = arr[i];            // Move it right by one
            arr[i+1] = temp;                  // Insert the element
        }
    } // sort()

    /**
     *  prints() an array 5 objects per line
     *  @param arr -- an array of objects that implement Comparable
     */
    public void print(Comparable arr[]) {
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
        Integer iArr[] = new Integer[TestSort.MAXSIZE]; // The Integer array
        Float fArr[] = new Float[TestSort.MAXSIZE];   // The Float array

        // Populate each array with randomly generated objects
        for (int k = 0; k < TestSort.MAXSIZE; k++) {
            iArr[k] = new Integer((int) (Math.random() * 10000));
            fArr[k] = new Float(Math.random() * 10000);
        }
       
        TestSort test = new TestSort();
        test.sort(iArr);     // Sort and print each array
        test.print(iArr);
	//        test.sort(fArr); 
        java.util.Arrays.sort(fArr);   // Use Arrays.sort()
        test.print(fArr);                      
    } // main()
} 
