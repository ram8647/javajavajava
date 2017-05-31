/*
 * File: ImagePanel.java
 * Author: Java, Java, Java
 * Description: This subclass of JPanel is used to
 *  display an image that is downloaded from a GIF file.
 */

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private RealEstateViewer frame;
 
    /**
     * ImagePanel() constructor sets a pointer to the
     *  panel's parent frame.
     */
    public ImagePanel(RealEstateViewer parent) {
        frame = parent;
    }

    /**
     * paintComponent() is invoked automatically to
     *  display the current image as given by the parent frame.
     */
    public void paintComponent(Graphics g) {
        setBackground(Color.yellow);
        if (frame.currentImage != null)
            g.drawImage(frame.currentImage, 0, 0, this);
    }
} // ImagePanel
