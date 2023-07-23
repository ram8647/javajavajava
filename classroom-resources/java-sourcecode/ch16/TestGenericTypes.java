/*
* Filename: TestGenericTypes.java
* Author: Java, Java, Java Edition 3
* Date: September 15, 2005
* Description: This program contains methods that illustrate
* the use of the Java Collections Framework and generic types.
*/

import java.util.*;

/*
* The TestGenericTypes class
* Description: This program contains methods that illustrate
* the use of the Java Collections Framework and generic types.
*/
public class TestGenericTypes{

    /**
    * testList() creates a list of PhoneRecord objects using the
    * LinkedList constructor and then prints out that list. This
    * method is listed in Figure 16.31.
    */
    public static void testList() {
        List<PhoneRecord> theList = new LinkedList<PhoneRecord>();
        // new ArrayList<PhoneRecord>() could also be used.
        theList.add(new PhoneRecord("Roger M", "090-997-2918"));
        theList.add(new PhoneRecord("Jane M", "090-997-1987"));
        theList.add(new PhoneRecord("Stacy K", "090-997-9188"));
        theList.add(new PhoneRecord("Gary G", "201-119-8765"));
        theList.add(new PhoneRecord("Jane M", "090-997-1987"));
        System.out.println("Testing a LinkedList List");
        for (PhoneRecord pr : theList)
            System.out.println(pr);
    } // testList()

    /**
    * testSet() creates a set of PhoneRecord objects using the
    * TreeSet constructor and then prints out that set. This
    * method is listed in Figure 16.33.
    */
    public static void testSet() {
        Set<PhoneRecord> theSet = new TreeSet<PhoneRecord>();
        // new HashSet<PhoneRecord>(); could also be used.
        theSet.add(new PhoneRecord("Roger M", "090-997-2918"));
        theSet.add(new PhoneRecord("Jane M", "090-997-1987"));
        theSet.add(new PhoneRecord("Stacy K", "090-997-9188"));
        theSet.add(new PhoneRecord("Gary G", "201-119-8765"));
        theSet.add(new PhoneRecord("Jane M", "090-987-6543"));

        System.out.println("Testing TreeSet and Set");
        PhoneRecord ph1 =
            new PhoneRecord("Roger M", "090-997-2918");
        PhoneRecord ph2 =
            new PhoneRecord("Mary Q", "090-242-3344");
        System.out.println("Roger M contained in theSet is");
        System.out.println(theSet.contains(ph1));
        System.out.println("Mary Q contained in theSet is");
        System.out.println(theSet.contains(ph2));
        for (PhoneRecord pr : theSet)
            System.out.println(pr);
    } // testSet()

    
    /**
    * testMap() creates a map of PhoneRecord objects using the
    * TreeMap constructor and then tests that map. This method
    * is listed in Figure 16.35.
    */
    public static void testMap() {
        Map<String,String> theMap = new TreeMap<String,String>();
        // new HashMap<String,String>(); could also be used.
        theMap.put("Roger M", "090-997-2918");
        theMap.put("Jane M", "090-997-1987");
        theMap.put("Stacy K", "090-997-9188");
        theMap.put("Gary G", "201-119-8765");
        theMap.put("Jane M", "090-233-0000");
        System.out.println("Testing TreeMap and Map");
        System.out.println("Stacy K has phone ");
        System.out.println(theMap.get("Stacy K"));
        System.out.println("Jane M has phone ");
        System.out.println(theMap.get("Jane M"));
    } // testMap()

    /**
    * main() just calls the above three methods.
    * @param args is not used.
    */
    public static void main(String[] args) {
        testList();
        System.out.println();
        testSet();
        System.out.println();
        testMap();
    } //main()

} // TestGenericTypes class
