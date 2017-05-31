In order to test this JSP you must start the Tomcat service.
On my Powerbook, the commands for starting and stopping Tomcat are:

   /Users/rmorelli/bin/start_tomcat
   /Users/rmorelli/bin/stop_tomcat

It appears that Tomcat caches pages, so I found it necessary to restart
the server every time I made a change to one of my test programs.

Once the server has been started, the main page may be accessed at
the following URL:

  http://localhost:8080/

That page has links to various demo programs, including JSPs and Java Servlets.

JSP files served up by the server may be put in the following directory:

   /usr/local/jakarta-tomcat-5.0.27/webapps/jjj3e/

Here is a listing of that directory:

   drwxr-xr-x   7 rmorelli  rmorelli  238 Aug 20  2004 WEB-INF
   -rw-r--r--   1 rmorelli  rmorelli  802 Aug 27  2004 example.jsp
   -rw-r--r--   1 rmorelli  rmorelli  353 Aug 16  2004 tagex.jsp

To run example.jsp, use the following URL:

   http://localhost:8080/jjj3e/example.jsp










