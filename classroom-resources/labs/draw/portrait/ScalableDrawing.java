/*
 *  File: ScalableDrawing.java
 *  Author: Java, Java, Java
 *  Description: The Drawable interface defines three methods used for drawing
 *   objects in which size and location can be changed.
 */

import java.awt.*;

public interface ScalableDrawing {
    public abstract void draw(Graphics g);
    public abstract void setSize(int s);
    public abstract void setLocation(int x, int y);
}//ScalableDrawing
