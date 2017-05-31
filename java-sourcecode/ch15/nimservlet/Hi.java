/**
  To Compile:  javac -classpath /usr/local/jakarta-tomcat-5.0.27/common/lib/servlet-api.jar:. Hi.java      
 */


import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * My test servlet
 *
 * @author Liz Warner
 */

public class Hi extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hola</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        out.println("<h1> Hi, from JJJ's hello servlet </h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
