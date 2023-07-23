 /*
 * File: NimServer.java
 * Author: Java, Java, Java
 * Description: This version of NimServer extends the
 *  generic Server class. It implements the provideService()
 *  method which plays the Nim game.
 *
 * NOTE: In order to compile and run this program access is needed
 *  to the following classes:
 *    NimPlayer.class
 *    Server.class, Client.class, ClientServer.class
 *    The twoplayer class hierarchy
 */
import java.net.*;
import java.io.*;

public class NimServer extends Server {
	
    /**
     * NimServer() constructor creates a server object given
     *  it port number and a number representing the number of
     *  clients it can backlog.
     * @param portNum -- an int giving the port number
     * @param nBacklog -- the number of clients that can backlog
     */    
    public NimServer(int port, int backlog) {
        super(port, backlog);
    }

    /**
     *  provideService() defines this server's service, which consists
     *   of simply echoing whatever string it receives from the client.
     *  The server's protocol calls for it to begin by saying hello
     *  and end by saying goodbye. Isn't it polite?
     */
    protected void provideService (Socket socket) {
	OneRowNim nim = new OneRowNim();
        try {
            writeToSocket(socket, "Hi Nim player. You're Player 1 and I'm Player 2. " +
 			 nim.reportGameState()  + " " + nim.getGamePrompt() + "\n");
	    play(nim, socket);
	} catch (IOException e) {
	    e.printStackTrace();
	} 
    } // provideService()

    private void play(OneRowNim nim, Socket socket) throws IOException {
        NimPlayer computerPlayer = new NimPlayer(nim);
        nim.addComputerPlayer(computerPlayer);
        String str="", response="";
        int userTakes = 0, computerTakes = 0;
        do {     
            str = readFromSocket(socket);
            boolean legalMove = false;
            do {
                userTakes = Integer.parseInt(str);
                if (nim.takeSticks(userTakes)) {
                    legalMove = true;
                    nim.changePlayer();
                    response = nim.reportGameState() + " ";
                    if (!nim.gameOver()) {
                        computerTakes = Integer.parseInt(computerPlayer.makeAMove(""));    
                        response = response + " My turn. I take " + computerTakes + " sticks. ";
                        nim.takeSticks(computerTakes);
                        nim.changePlayer();
                        response = response + nim.reportGameState() + " ";
                        if (!nim.gameOver())
                             response = response + nim.getGamePrompt();
                    }
                    writeToSocket(socket, response);
                } else {
                   writeToSocket(socket, "That's an illegal move. Try again.\n");
                  str = readFromSocket(socket);
                }
            } while (!legalMove);
        }  while (!nim.gameOver());
    }

    // Overriding writeToSocket to remove \n from str
    protected void writeToSocket(Socket soc, String str) throws IOException {
	StringBuffer sb = new StringBuffer();
        for (int k = 0; k < str.length(); k++)
            if (str.charAt(k) != '\n')
		sb.append(str.charAt(k));
        super.writeToSocket(soc, sb.toString() + "\n");
    }
 
     /** 
      *  main() creates an EchoServer at port 10001
      */
    public static void main(String args[]) {
        NimServer server = new NimServer(10001,5);
        server.start();
    } // main()
} // NimServer
