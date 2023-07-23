/*
 * File: EchoClient.java<2>
 * Author: Java, Java, Java
 * Description: This version of EchoClient extends the
 *   generic Client class. It implements the requestService()
 *   method to define a particular echo service in which input
 *   is accepted from the user and sent to the server. The
 *   server simply echos what it receives.
 */

import java.net.*;
import java.io.*;

public class EchoClient extends Client {
  
    /**
     * EchoClient() constructor creates a client object
     *   given the server's url and port
     * @param url -- a String giving the server's URL
     * @param port -- an int giving the port number
     */
    public EchoClient( String url, int port ) {
        super(url,port);
    }
   	
    /**
     * requestService() repeatedly accepts input from the
     *  user and transmits it to the server, which echos it.
     * @param socket -- a Socket connection to the server
     */
    protected void requestService(Socket socket) throws IOException { 
        String servStr = readFromSocket(socket);            // Check FOR "Hello"
        System.out.println("SERVER: " + servStr);           // Report the server's response
        System.out.println("CLIENT: type a line or 'goodbye' to quit"); // Prompt the user
        if ( servStr.substring(0,5).equals("Hello") ) {
            String userStr = "";
            do {
                userStr = readFromKeyboard();                  // Get input from user
                writeToSocket(socket, userStr + "\n");         // Send it to server
                servStr = readFromSocket(socket);              // Read the server's response
                System.out.println("SERVER: " + servStr);      // Report the server's response
            } while(!userStr.toLowerCase().equals("goodbye")); // Until user says 'goodbye'
        }
    } // requestService()

    /**
     * main() creates an EchoClient object and makes a connection
     *  to the echo server.
     */
    public static void main(String args[]) {
        EchoClient client = new EchoClient("localhost", 10001);
        client.start();
    } // main()
} // EchoClient
