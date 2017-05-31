/*
 *  File: TestSearch.java
 *  Author: Java, Java, Java
 *  Description: This program tests the methods of the
 *   Search class. It creates a Search object and uses
 *   it to perform binary and sequential search of an
 *   array of integers.
 */
public class TestSearch {
    /**
     * getInput()  reads an integer from the keyboard and returns it
     * @return the the integer read
     * Pre: none
     * Post: the input integer is returned
     */
    public static int getInput() {
        KeyboardReader kb = new KeyboardReader();
        kb.prompt("This program searches for values in an array.\n");
        kb.prompt("Input any positive integer (or any negative to quit) : ");
        return kb.getKeyboardInteger();
    } // getInput()

    /**
     *  main() creates a Search instance and uses it to perform searches
     *   of an integer array. The user is repeatedly prompted to input
     *   a number to search for.
     */
    public static void main(String args[])  {
        KeyboardReader kb = new KeyboardReader();
        int intArr[] = { 2,4,6,8,10,12,14,16,18,20,22,24,26,28};
        Search searcher = new Search();
        int key = 0, keyAt = 0;
        key = getInput();
        while (key >= 0) {
            keyAt = searcher.sequentialSearch( intArr, key );
            if (keyAt != -1)
                System.out.println("  Sequential: " + key + " is at intArr[" + keyAt + "]");
            else
                System.out.println("  Sequential: " + key + " is not contained in intArr[]");
            keyAt = searcher.binarySearch(intArr, key);
            if (keyAt != -1)
                System.out.println("  Binary: " + key + " is at intArr[" + keyAt + "]");
            else
                System.out.println("  Binary: " + key + " is not contained in intArr[]");
            key = getInput();
        } // while
    } // main()
} // TestSearch
