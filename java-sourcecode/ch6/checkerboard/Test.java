public class Test {

    public static void main(String args[]) {
        int arr[] = { 1, 12, 14, 5, 6, 1, 76, 12, 1, 21, 2};
        StringBuffer sb = new StringBuffer();
        for (int k=0; k < arr.length; k++) 
            sb.append(arr[k]);
        System.out.println(sb.toString());
    }
}
