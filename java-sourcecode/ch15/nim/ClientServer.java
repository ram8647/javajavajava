/*
 * File: ClientServer.java
 * Author: Java, Java, Java
 * Description: This Thread subclass contains I/O
 *  methods used for reading and writing socket streams.
 *  It serves as the superclass for both Client and Server
 *  classes.
 */

import java.io.*;    
import java.net.*;   

public class ClientServer extends Thread {

    protected InputStream iStream;            // Instance variables
    protected OutputStream oStream; 

    /**
     *  readFromSocket() reads one line of data from a socket and
     *   returns it as a string
     *  @param sock -- a reference to the Socket object
     */
    protected String readFromSocket(Socket sock) throws IOException {
        iStream = sock.getInputStream();
        String str="";
        char c;
        while (  ( c = (char) iStream.read() ) != '\n') 
            str = str + c + "";
            return str;
        }

    /**
     *  writeToSocket() reads a String to a given socket
     *  @param sock -- a reference to the Socket object
     *  @param str -- the string to be written
     */
    protected void writeToSocket(Socket sock, String str) throws IOException {
        oStream = sock.getOutputStream();
        if (str.charAt( str.length() - 1 ) != '\n')
            str = str + '\n';
        for (int k = 0; k < str.length() ; k++)
            oStream.write(str.charAt(k));
    } // writeToSocket()
} // ClientServer
