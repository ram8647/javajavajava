/*
 * File: Player.java
 * Author: Java, Java, Java
 * Description: The superclass for computer game players,
 *  which can be either a computer or a numan player.
 */
public class Player  {   
    public static final int COMPUTER=0;
    public static final int HUMAN=1;
    protected int id = -1;            // An int between 0 and nPlayers-1
    protected int kind = HUMAN;

    /**
     * Player default constructor
     */
    public Player() { }

    /**
     * Player constructor sets the id and kind of a player
     * @param id is an int giving the player's id number
     * @param kind is either HUMAN or COMPUTER
     */
    public Player(int id, int kind) {
        this.id = id;
        this.kind = kind;
    }

    /**
     * setID() sets the ID number of this player
     * @param k is the ID number
     */
    public void setID(int k) {
        id = k;
    }

    /**
     * getID() returns the ID number of this player
     */
    public int getID() {
        return id;
    }

    /**
     * setKind() sets this player's kind to HUMAN or COMPUTER
     */
    public void setKind(int k) {
        kind = k;
    }

    /**
     * getKind() returns this player's kind (either HUMAN or COMPUTER)
     */
    public int getKind() {
        return kind;
    }

    /**
     * isComputer() returns true if this player is a COMPUTER
     */
    public boolean isComputer() {
        return kind == COMPUTER;
    }
} // Player

