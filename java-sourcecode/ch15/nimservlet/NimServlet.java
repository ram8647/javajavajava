 /*
 * File: NimServlet.java
 * Author: Java, Java, Java
 * Description: A servlet version of NimServer that plays the game of Nim.
 */
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NimServlet extends HttpServlet {
    
    private OneRowNim nim = null;
    private NimPlayer nimPlayer = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Simple Nim Game</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<center><h1>One Row Nim</h1></center>");
        out.println("<center><h3>The Rules</h3>");
        out.println("A random number of pennies is thrown on the table.<BR>");
        out.println("Two players alternate making moves,<BR>");
        out.println("picking up between 1 and 3 pennies on each move.<BR>");
        out.println("The player who picks up the last penny loses.<BR><BR>");
        if (nim == null) {
            nim = new OneRowNim(7 + (int)(Math.random() * 11));
            nimPlayer = new NimPlayer(nim);
            out.println("<h4>You go first!</h4></center>");
	} else {
            int userTakes = Integer.parseInt(request.getParameter("pickup"));
            if (!nim.takeSticks(userTakes)) {
		out.println("<h4><font color='red'>Woops. That's an illegal move!. Try again. </font><h4>");
	    } else if (!nim.gameOver()) {
                nim.changePlayer();
                out.println("<h4>So, you took <font color='blue'>" + userTakes + "</font><BR>"); 
                out.println("That leaves me with <font color='blue'>" + nim.getSticks() + "</font><BR>");
                int iTake = nimPlayer.move();
                out.println("OK. I take <font color='red'>" + iTake + " </font>pennies.<BR></h4>");
                nim.takeSticks(iTake);
                nim.changePlayer();
	    }
	}
        if (!nim.gameOver()) {
            if (nim.getPlayer() == 1)
                out.println("<center><h3>Who's Turn: <font color='magenta'> Your turn </font><h3></center>");
            else
                out.println("<center><h3>Who's Turn: <font color='magenta'> My turn </font><h3></center>");
            out.println("<center><h3>Pennies Left: <font color='red'>" + nim.getSticks() + "</font><h3></center>");
            out.println("<center>");
            for (int k=0; k < nim.getSticks(); k++)
              out.println("<img src='http://xroads.virginia.edu/~CAP/LINCOLN/cent.jpg' width='25' height='25'>");
		//                 out.println("<img src='http://localhost:8080/jjj3e/cent.jpg' width='25' height='25'>");
            out.println("</center><br>");

            out.println("<center>");
            out.println("<form action=\"/jjj3e/NimServlet\" method=\"POST\">");
            out.println("<table border=\"0\">");
            out.println("<tr><td>How many do you pickup?: </td><td><input type=\"text\" name=\"pickup\" value=\"0\"></td></tr>");
            out.println("</table>");
            out.println("</center>");
            out.println("</form>");
	} else {
            out.println("<h3><font color='red'>Game over!</font><h3>");
            if (nim.getPlayer() == 1)
                out.println("<center><h4>And the winner is : <font color='magenta'> Me.</font><h4></center>");
            else
                out.println("<center><h4>And the winner is: <font color='magenta'> You.</font><h4></center>");
            out.println("<center><h4><font color='magenta'> Nice game!</font><h4></center>");
            out.println("<center><h4>To play again, just reload the page.<h4></center>");
            nim = null;
	}
        
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * We are going to perform the same operations for POST requests
     * as for GET methods, so this method just sends the request to
     * the doGet method.
     */

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
    {
        doGet(request, response);
    }

} // NimServlet
