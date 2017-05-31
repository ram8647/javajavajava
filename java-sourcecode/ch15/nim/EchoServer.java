 /*
 * File: EchoServer.java<2>
 * Author: Java, Java, Java
 * Description: This version of EchoServer extends the
 *  generic Server class. It implements the provideService()
 *  method which simply echos strings input by the user.
 *  The server object reads a string sent by a client
 *  and sends the same string back over the socket.
 */
import java.net.*;
import java.io.*;

public class EchoServer extends Server {
	
    /**
     * EchoServer() constructor creates a server object given
     *  it port number and a number representing the number of
     *  clients it can backlog.
     * @param portNum -- an int giving the port number
     * @param nBacklog -- the number of clients that can backlog
     */    
    public EchoServer(int port, int backlog) {
        super(port, backlog);
    }

    /**
     *  provideService() defines this server's service, which consists
     *   of simply echoing whatever string it receives from the client.
     *  The server's protocol calls for it to begin by saying hello
     *  and end by saying goodbye. Isn't it polite?
     */
    protected void provideService (Socket socket) {
       String str="";
       try {
           writeToSocket(socket, "Hello, how may I help you?\n");
           do {     
               str = readFromSocket(socket);
               if (str.toLowerCase().equals("goodbye"))
                   writeToSocket(socket, "Goodbye\n");
               else
                   writeToSocket(socket, "You said '" + str + "'\n");
           }  while (!str.toLowerCase().equals("goodbye"));
       } catch (IOException e) {
           e.printStackTrace();
       }
    } // provideService()
 
     /** 
      *  main() creates an EchoServer at port 10001
      */
    public static void main(String args[]) {
        EchoServer server = new EchoServer(10001,5);
        server.start();
    } // main()
} // EchoServer
