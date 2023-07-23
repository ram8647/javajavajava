/*
 *  File: Search.java
 *  Author: Java, Java, Java
 *  Description: This class implements sequential and
 *   binary search methods for one-dimensional arrays.
 */

public class Search {

    /**
     * sequentialSearch() performs a sequential search of an integer array
     * @param arr is the array of integers
     * @param key is the element being searched for
     * @return the key's index is returned if the key is
     *  found otherwise -1 is returned
     * Pre:  arr is not null
     * Post: either -1 or the key's index is returned
     */
    public int sequentialSearch(int arr[], int key) {
        for (int k = 0; k < arr.length; k++)
            if (arr[k] == key)
                return k;
        return -1;           // Failure if this is reached
    } // sequentialSearch()

    /**
     * binarySearch() performs a binary search of an integer array
     * @param arr is the array of integers
     * @param key is the element being searched for
     * @return the key's index is returned if the key is
     *  found otherwise -1 is returned
     * Pre: arr is an array of int in ascending order
     * Post: -1 or arr[k] where arr[k] == key
     */
    public int binarySearch(int arr[], int key) {
        int low = 0;				// Initialize bounds
        int high = arr.length - 1;
        while (low <= high) {                   // While not done
            int mid = (low + high) / 2; 
            if (arr[mid] == key)
                return mid;                     // Success
            else if (arr[mid] < key)
                low = mid + 1;                  // Search top half
            else
                 high = mid - 1;                // Search bottom half
        }  // while 	
        return -1;    // Post condition: low > high implies search failed
    } // binarySearch()
}//Search
