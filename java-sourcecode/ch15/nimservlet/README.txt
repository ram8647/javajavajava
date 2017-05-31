In order to test this servlet you must start the Tomcat service.
On my Powerbook, the commands for starting and stopping Tomcat are:

   /Users/rmorelli/bin/start_tomcat
   /Users/rmorelli/bin/stop_tomcat

It appears that Tomcat caches pages, so I found it necessary to restart
the server every time I made a change to one of my test programs.

Once the server has been started, the main page may be accessed at
the following URL:

  http://localhost:8080/

That page has links to various demo programs, including JSPs and Java Servlets.

Files served up by the server must be located in the following directory:

   /usr/local/jakarta-tomcat-5.0.27/webapps/jjj3e/WEB-INF/classes

Here is a listing of that directory:

  -rw-r--r--    1 rmorelli  rmorelli    162 Jan  2 10:37 CLUIPlayableGame.class
  -rw-r--r--    1 rmorelli  rmorelli   2220 Aug 16  2004 DBtest.class
  -rw-r--r--    1 rmorelli  rmorelli   2945 Aug 16  2004 DBtest.java
  -rw-r--r--    1 rmorelli  rmorelli    137 Jan  2 10:37 Drawable.class
  -rw-r--r--    1 rmorelli  rmorelli    190 Jan  2 10:37 GUIPlayableGame.class
  -rw-r--r--    1 rmorelli  rmorelli    877 Jan  2 10:16 Hi.class
  -rw-r--r--    1 rmorelli  rmorelli    893 Jan  2 10:16 Hi.java
  -rw-r--r--    1 rmorelli  rmorelli    164 Jan  2 10:37 IGame.class
  -rw-r--r--    1 rmorelli  rmorelli    156 Jan  2 10:37 IPlayer.class
  -rw-r--r--    1 rmorelli  rmorelli   1404 Jan  2 10:37 KeyboardReader.class
  drwxr-xr-x    3 rmorelli  rmorelli    102 Jan  2 10:37 META-INF
  -rw-r--r--    1 rmorelli  rmorelli    973 Jan  2 10:32 Nim.class
  -rw-r--r--    1 rmorelli  rmorelli   1011 Jan  2 10:32 NimPlayer.class
  -rw-r--r--    1 rmorelli  rmorelli   3910 Jan  2 10:32 NimServlet.class
  -rw-r--r--    1 rmorelli  rmorelli   3363 Jan  2 10:32 OneRowNim.class
  -rw-r--r--    1 rmorelli  rmorelli    133 Jan  2 10:37 Playable.class
  -rw-r--r--    1 rmorelli  rmorelli   1036 Jan  2 10:37 TwoPlayerGame.class
  -rw-r--r--    1 rmorelli  rmorelli    211 Jan  2 10:37 UserInterface.class
  -rw-r--r--    1 rmorelli  rmorelli  29751 Aug 20  2004 cent.jpg
  -rw-r--r--    1 rmorelli  rmorelli   3251 Aug 16  2004 mail.class
  -rw-r--r--    1 rmorelli  rmorelli   4300 Aug 16  2004 mail.java

I tried to group the twoplayer classes into a jar file, but the Server was
unable to find them. It worked when I dumped the entire twoplayer.jar into
the WEB-INF/classes directory.

To run the NimServlet, the following URL is used:

   http://localhost:8080/jjj3e/NimServlet

To run the Hi servlet, the following URL is used:

   http://localhost:8080/jjj3e/Hi








