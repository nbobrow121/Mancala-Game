package mancala;

import java.util.ArrayList;

/**
 * Abstract class representing the rules of a Mancala game.
 * KalahRules and AyoRules will subclass this class.
 */
public abstract class GameRules {
    private final MancalaDataStructure gameBoard;
    private int currentPlayer = 1; // Player number (1 or 2)
   
    final private ArrayList<Store> pitStores;

    /**
     * Constructor to initialize the game board.
     */
    public GameRules() {
        gameBoard = new MancalaDataStructure();
        pitStores = new ArrayList<>();
        setUpStores();
    }

    public final void setUpStores() {
        //clear the stores
        pitStores.clear();
        //Add the new stores to the array list
        pitStores.add(new Store());
        pitStores.add(new Store());
    }

    /**
     * Get the number of stones in a pit.
     *
     * @param pitNum The number of the pit.
     * @return The number of stones in the pit.
     */
    public int getNumStones(final int pitNum) {
        return gameBoard.getNumStones(pitNum);
    }
    
    /**
     * Get the game data structure.
     *
     * @return The MancalaDataStructure.
     */
    MancalaDataStructure getDataStructure() {
        return gameBoard;
    }

    /**
     * Check if a side (player's pits) is empty.
     *
     * @param pitNum The number of a pit in the side.
     * @return True if the side is empty, false otherwise.
     */
    boolean isSideEmpty(final int pitNum) throws PitNotFoundException{
        if (pitNum < 1 || pitNum > 12) {
            throw new PitNotFoundException("Invalid pit");
        }
    
        int startPit = (pitNum <= 6) ? 1 : 7;
        int endPit = (pitNum <= 6) ? 6 : 12;
    
        for (int i = startPit; i <= endPit; i++) {
            if (gameBoard.getNumStones(i) > 0) {
                return false;
            }
        }
        return true;
    }    

    /**
     * Set the current player.
     *
     * @param playerNum The player number (1 or 2).
     */
    public void setPlayer(final int playerNum) {
        currentPlayer = playerNum;
    }

    public int getPlayer() {
        return currentPlayer;
    }
    /**
     * Perform a move and return the number of stones added to the player's store.
     *
     * @param startPit  The starting pit for the move.
     * @param playerNum The player making the move.
     * @return The number of stones added to the player's store.
     * @throws InvalidMoveException If the move is invalid.
     */
    public abstract int moveStones(int startPit, int playerNum) throws InvalidMoveException;

    /**
     * Distribute stones from a pit and return the number distributed.
     *
     * @param startPit The starting pit for distribution.
     * @return The number of stones distributed.
     */
    abstract int distributeStones(int startPit);

    /**
     * Capture stones from the opponent's pit and return the number captured.
     *
     * @param stoppingPoint The stopping point for capturing stones.
     * @return The number of stones captured.
     */
    abstract int captureStones(int stoppingPoint);

    /**
     * Register two players and set their stores on the board.
     *
     * @param one The first player.
     * @param two The second player.
     */
    public void registerPlayers(final Player one, final Player two) {

        setUpStores();
        pitStores.get(0).setOwner(one);
        pitStores.get(1).setOwner(two);
        one.setStore(pitStores.get(0));
        two.setStore(pitStores.get(1));
        gameBoard.setStore(pitStores.get(0),1);
        gameBoard.setStore(pitStores.get(1),2);
            // this method can be implemented in the abstract class.


        /* make a new store in this method, set the owner
         then use the setStore(store,playerNum) method of the data structure*/
    }

    /**
     * Reset the game board by setting up pits and emptying stores.
     */
    public void resetBoard() {
        gameBoard.setUpPits();
        gameBoard.emptyStores();
    }

    //toString method to display the mancala board
    @Override
    public String toString() {
        final StringBuilder displayBoard = new StringBuilder(); 
        displayBoard.append("-----------------Mancala Board Representation-----------------").append("\n");
        displayBoard.append(pitStores.get(0).getOwner().toString());

        //display player 1s side of the board
        displayBoard.append("\n");
        for (int i = 1; i < 7; i++){
            displayBoard.append(i + ":[").append(getNumStones(i)).append("] "); 
        }
        displayBoard.append("\nP1 store: ").append(pitStores.get(0).toString());
        displayBoard.append("\n").append(pitStores.get(1).getOwner().toString());

        //display player 2s side of the board
        displayBoard.append("\n");
        for (int j = 7; j < 13; j++){
            displayBoard.append(j + ":[").append(getNumStones(j)).append("] "); 
        }
        displayBoard.append("\nP2 store: ").append(pitStores.get(1).toString());

        return displayBoard.toString();
    }
}

