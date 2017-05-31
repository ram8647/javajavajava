import java.awt.*;

public class CheckerBoard
{   // Default values for a standard checkerboard
    private int leftX = 10;    //position of  left
    private int upperY = 10;   //upper corner of board
    private int sqSide = 40;   //size of each square
    private int nRows = 8;     //checkerboard rows
    private int nCols = 8;     //checkerboard columns
    private Color sqColor1 = Color.lightGray; //colors
    private Color sqColor2 = Color.blue;  //of squares
    private Color chColor1 = Color.red;   //colors of
    private Color chColor2 = Color.black; //checkers

    private void drawSquare(Graphics g, int row, int col)
    {   if ((row + col) % 2 == 0) // Color squares alternately
            g.setColor(sqColor1); // Light
        else
            g.setColor(sqColor2); // Or dark
        g.fillRect(leftX+col*sqSide,
                    upperY+row*sqSide,sqSide,sqSide);
    }//drawSquare()

    private void drawChecker(Graphics g, int row, int col)
    {// Initial position of checkers on dark squares
        if ((row + col)%2 == 1) // One player has checkers on top 3 rows
        {   if (row < 3)
            {   g.setColor(chColor1);
                g.fillOval(leftX+col*sqSide,
                    upperY+row*sqSide,sqSide,sqSide);
            }//if
            if (row >= nRows - 3)  // The other has checkers on bottom 3 rows
            {   g.setColor(chColor2);
                g.fillOval(leftX+col*sqSide,
                    upperY+row*sqSide,sqSide,sqSide);
            }//if
        }//if
    }//drawChecker()

    public void draw(Graphics g) // Draw the checkerboard and checkers
    {   for(int row = 0; row < nRows; row++)  // For each row of the checkerboard
        {   for(int col = 0; col < nCols; col++)  // For each square in the row
            {   drawSquare(g, row, col);
                drawChecker(g, row, col);
            }//for
        }//for
    } //draw
} //CheckerBoard
