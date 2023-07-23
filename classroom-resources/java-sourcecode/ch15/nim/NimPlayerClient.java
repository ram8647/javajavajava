public class NimPlayer extends Client implements IPlayer
{   private OneRowNim game;
    public NimPlayer (OneRowNim game) {   
        this.game = game;
    }
    public NimPlayer (OneRowNim game, String url, int port) {   
        super(url,port);
        this.game = game;
    }

    /**
     * requestService() repeatedly accepts input from the
     *  user and transmits it to the server, which echos it.
     * @param socket -- a Socket connection to the server
     */
    protected void requestService(Socket socket) throws IOException { 
        String servStr = readFromSocket(socket);            // Check FOR "Hello"
        System.out.println("SERVER: " + servStr);           // Report the server's response
        System.out.println("CLIENT: type a Nim move or 'goodbye' to quit"); // Prompt the user
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

    public int move() {   
        int sticksLeft = game.getSticks();
        if (sticksLeft % (game.MAX_PICKUP + 1) != 1)
            return (sticksLeft - 1) % (game.MAX_PICKUP +1);
        else {
            int maxPickup = Math.min(game.MAX_PICKUP, sticksLeft);
            return 1 + (int)(Math.random() * maxPickup);
        }
    }
    public String makeAMove(String prompt) {   
        return ""+ move();
    }
    public String toString() {
        String className = this.getClass().toString(); // returns 'class NimPlayerBad'
        return className.substring(5);                 // cut off the word 'class'
    }
} // NimPlayer
