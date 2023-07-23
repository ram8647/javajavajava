public class Rectangle {

    private static int nRectangles = 0;
    private static final int MAXRECTS = 5;
    private double length;
    private double width;

    public Rectangle (double l, double w) throws Exception {
        if (nRectangles == MAXRECTS)
            throw new Exception("Rectangle limit reached");
        ++nRectangles;
        length = l;
        width = w;
    }

    public static int howManyRectangles() {
        return nRectangles;
    }

    public double calculateArea() {
        return length * width;
    }

    public static void main (String args[]) throws Exception {
        System.out.println("There are now " + Rectangle.howManyRectangles() + " rectangles");
        Rectangle r1 = new Rectangle(25, 10);
        System.out.println("There are now " + Rectangle.howManyRectangles() + " rectangles");
        Rectangle r2 = new Rectangle(30, 5);
        System.out.println("There are now " + Rectangle.howManyRectangles() + " rectangles");
        Rectangle r3 = new Rectangle(30, 5);
        System.out.println("There are now " + Rectangle.howManyRectangles() + " rectangles");
        Rectangle r4 = new Rectangle(30, 5);
        System.out.println("There are now " + Rectangle.howManyRectangles() + " rectangles");
        Rectangle r5 = new Rectangle(30, 5);
        System.out.println("There are now " + Rectangle.howManyRectangles() + " rectangles");
        Rectangle r6 = new Rectangle(30, 5);
        System.out.println("There are now " + Rectangle.howManyRectangles() + " rectangles");
    }
}
