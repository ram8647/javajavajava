/*
 * File: Client.java
 * Author: Java, Java, Java
 * Description:  This abstract Client class defines a
 *  generic Client object. Its run() method, inherited
 *  from Thread via ClientServer, defines the basic
 *  Client behavior, as that of requesting some service
 *  from a server via a socket connection. 
 *  The details of the client's behavior are defined in the 
 *  Client subclass.
 */

import java.net.*;
import java.io.*;

public abstract class Client extends ClientServer {
	
    protected Socket socket;

    /**
     * Client() constructor creates a client object given
     *  the server's URL and port number.
     * @param ulr -- a String giving the server's URL
     * @param port -- an int giving the port number
     */    
    public Client(String url, int port) {
        try {
            socket = new Socket(url, port);
            System.out.println("CLIENT: connected to " + url + ":" + port);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    } // Client()

    /**
     *  run() defines the client thread's main behavior which is
     *   simply to request service from the given server.
     *   Since an I/O exception may result, it is handled here. 
     */
    public void run() {
        try {
            requestService(socket);
            socket.close();
            System.out.println("CLIENT: connection closed");
        } catch (IOException e) { 
            System.out.println(e.getMessage());
            e.printStackTrace(); 
        }
    } // run()
 
    /**
     *  requestService() is implemented in the subclass
     */
    protected abstract void requestService(Socket socket) throws IOException;

    /**
     *  readFromKeyboard() is a utility method that reads input from the keyboard
     */
    protected String readFromKeyboard( ) throws IOException {
        BufferedReader input = new BufferedReader ( new InputStreamReader (System.in) );
        System.out.print("INPUT: ");
        String line = input.readLine();
        return line;
    } // readFromKeyboard()
} // Client
