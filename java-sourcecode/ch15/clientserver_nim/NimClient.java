/*
 * File: NimClient.java<2>
 * Author: Java, Java, Java
 * Description: This version of NimClient extends the
 *   generic Client class. It implements the requestService()
 *   method to define a particular echo service in which input
 *   is accepted from the user and sent to the server. The
 *   server simply echos what it receives.
 *
 * NOTE: In order to compile and run this program access is needed
 *  to the following classes:
 *    NimPlayer.class
 *    Server.class, Client.class, ClientServer.class
 *    The twoplayer class hierarchy
 */

import java.net.*;
import java.io.*;

public class NimClient extends Client {
    private KeyboardReader kb = new KeyboardReader();
  
    /**
     * NimClient() constructor creates a client object
     *   given the server's url and port
     * @param url -- a String giving the server's URL
     * @param port -- an int giving the port number
     */
    public NimClient( String url, int port ) {
        super(url,port);
    }
   	
    /**
     * requestService() repeatedly accepts input from the
     *  user and transmits it to the server, which echos it.
     * @param socket -- a Socket connection to the server
     */
    protected void requestService(Socket socket) throws IOException { 
        String servStr = readFromSocket(socket);            // Get server's response
        kb.prompt("NIM SERVER: " + servStr + "\n");           // Report the server's response
        if ( servStr.substring(0,6).equals("Hi Nim") ) {
            String userStr = "";
            do {
                userStr = kb.getKeyboardInput();                  // Get input from user
                writeToSocket(socket, userStr + "\n");         // Send it to server
                servStr = readFromSocket(socket);              // Read the server's response
                kb.prompt("NIM SERVER: " + servStr + "\n");      // Report the server's response
            } while(servStr.indexOf("Game over!") == -1); // Until game over
        }
    } // requestService()

    /**
     * main() creates an NimClient object and makes a connection
     *  to the echo server.
     */
    public static void main(String args[]) {
        NimClient client = new NimClient("localhost", 10001);
        client.start();
    } // main()
} // NimClient
