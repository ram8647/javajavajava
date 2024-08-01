import java.util.Arrays;

public class MethodTester {
    public static String stringify(Object[] s) {
        StringBuffer sb = new StringBuffer();
        int width = 0;
	final int MAX_WIDTH = 60;
	for(Object o : s) {
	   if(width + o.toString().length() >= MAX_WIDTH) {
	      sb.append("\n");
	      width = 0;
	   }
           sb.append(o.toString());
	   sb.append(",");
	   width += o.toString().length() + 1;
	}
	if (sb.charAt(sb.length()-1) == ',') {
           sb.deleteCharAt(sb.length()-1);
	   sb.append("\n");
	}

	return sb.toString();
    }
    public static void main(String args[]) {
        Integer[] x = new Integer[100];
        Arrays.fill(x,12345);
        System.out.println("the array is:\n" + stringify(x));
    }
}
