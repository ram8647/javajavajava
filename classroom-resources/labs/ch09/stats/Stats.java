/**
  Partial implementation of Stats.java
***/

public class Stats {


   private int grades[];
   private int count;
   
   
   public Stats()
   {
    grades = new int[100];
    count = 0;
    }//end Stats
      
   
   // INSERTION SORT OF THE FIRST n ELEMENTS OF ARRAY arr
   // SEE PAGE 420 TO PAGE 423 FOR A DISCUSSION

   public void sort(int[] grades, int count) {
    int temp, j, k;
    for(j = 1; j < count; j++){
      temp = grades[j];
      for (k = j - 1; ( k >= 0) && (grades[k] > temp) ; k-- ){
          grades[k + 1] = grades[k];
       } // for k
       grades[k + 1] = temp;
     } // for j       
   }//sort
     
 
}//Stats
