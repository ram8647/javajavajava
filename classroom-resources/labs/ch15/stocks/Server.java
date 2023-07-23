/*
 * File: Server.java
 * Author: Java, Java, Java
 * Description:  This abstract Server class defines a
 *  generic Server object. Its run() method, inherited
 *  from Thread via ClientServer, defines the basic
 *  Server behavior, as that of providing some service
 *  to clients whenever a socket connection is accepted.
 *  The actual service provided is defined in the 
 *  Server subclass.
 */

import java.net.*;
import java.io.*;

public abstract class Server extends ClientServer {
	
    protected ServerSocket port;
    protected Socket socket;

    /**
     * Server() constructor creates a server object given
     *  its port number and a number representing the number of
     *  clients it can backlog.
     * @param portNum -- an int giving the port number
     * @param nBacklog -- the number of clients that can backlog
     */    
    public Server(int portNum, int nBacklog)  {
        try {
            port = new ServerSocket (portNum, nBacklog);
        } catch (IOException e) {
            e.printStackTrace();
        }     
    } // Server()

    /**
     *  run() defines the server thread's main behavior which is
     *   simply to provide service whenever it is requested by a client. 
     *   Since an I/O exception may result, it is handled here. The
     *   server repeatedly accepts a connection from a client and
     *   provides it whatever service is defined in provideService().
     */
    public void run() {
        try {

            while (true) {
                socket = port.accept();
                System.out.println("Accepted a connection from " + socket.getInetAddress());
                provideService(socket);
                socket.close();
                System.out.println("Closed the connection\n");
            } // while
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // run()

    /**
     *  provideService() is implemented in the subclass
     */
    protected abstract void provideService(Socket socket);   // Implemented in server subclasses
 
} // Server
